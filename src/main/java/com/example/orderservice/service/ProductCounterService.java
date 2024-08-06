package com.example.orderservice.service;

import com.example.orderservice.dto.ProductCounterDto;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.entity.ProductCounter;

import java.util.List;

public interface ProductCounterService {

    public List<ProductCounter> getAllOrders();
    public ProductCounterDto getOrderDto(Long id);
    public ProductCounter updateOrder(ProductCounter productCounter);

    public void deleteOrder(Long id);

    public OrderResponse createOrder(ProductCounterDto productCounterDto);
}
