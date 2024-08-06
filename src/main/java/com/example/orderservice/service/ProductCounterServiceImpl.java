package com.example.orderservice.service;

import com.example.orderservice.dto.ProductCounterDto;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.dto.ProductResponse;
import com.example.orderservice.entity.Message;
import com.example.orderservice.entity.ProductCounter;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.repository.ProductCounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCounterServiceImpl implements ProductCounterService {


    private final ProductCounterRepository productCounterRepository;
    private final OrderService orderService;
    private final ProductClient productClient;
    String notFound = Message.NOT_FOUND.getMessage();
    String notEnough = Message.NOT_ENOUGH.getMessage();


    @Override
    public List<ProductCounter> getAllOrders() {
        return productCounterRepository.findAll();
    }

    @Override
    public ProductCounterDto getOrderDto(Long id) {
        ProductCounter productCounter = productCounterRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found - " + id));
        return ProductCounterDto.builder()
                .productId(productCounter.getProductId())
                .quantity(productCounter.getQuantity())
                .orderId(productCounter.getOrders().getId())
                .build();

    }

    @Override
    public OrderResponse createOrder(ProductCounterDto productCounterDto){
        ProductCounter productCounter = ProductCounter.builder()
                .productId(productCounterDto.getProductId())
                .quantity(productCounterDto.getQuantity())
                .orders(orderService.readOrder(productCounterDto.getOrderId()))
                .build();
        ProductResponse product = productClient.getProductResponse(productCounter.getProductId(), productCounter.getQuantity());
        if (product.getMessage().equals(notFound)) {
            return new OrderResponse(null, notFound);
        }
        if (product.getMessage().equals(notEnough)){
                return new OrderResponse(productCounter, notEnough);
        }
        productCounterRepository.save(productCounter);
        return new OrderResponse(productCounter, "The request was successfully completed");
    }

    @Override
    public ProductCounter updateOrder(ProductCounter productCounter) {
        return productCounterRepository.save(productCounter);
    }

    @Override
    public void deleteOrder(Long id) {
        productCounterRepository.deleteById(id);

    }


}
