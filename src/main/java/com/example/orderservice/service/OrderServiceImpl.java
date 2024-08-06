package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public Order addOrder(OrderDto orderDto) {
        return orderRepository.save(
                Order.builder()
                        .numberOrder(orderDto.getNumberOrder())
                        .build()
        );
    }

    @Override
    public OrderDto getOrder(Long id) {
        var order = orderRepository.findById(id).orElseThrow(()-> new RuntimeException("Order not found -" + id));
        return OrderDto.builder()
                .numberOrder(order.getNumberOrder())
                .build();
    }

    @Override
    public Order readOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(()-> new RuntimeException("Order not found -" + id));
    }

}
