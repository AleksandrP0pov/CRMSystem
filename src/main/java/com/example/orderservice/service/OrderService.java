package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.entity.Order;
public interface OrderService {
    public Order addOrder(OrderDto orderDto);

    public OrderDto getOrder(Long id);

    public Order readOrder(Long id);
}
