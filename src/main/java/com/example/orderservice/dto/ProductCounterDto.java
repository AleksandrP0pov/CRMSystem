package com.example.orderservice.dto;

import jakarta.persistence.criteria.Order;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCounterDto {
    private Long productId;
    private int quantity;
    private Long orderId;
}

