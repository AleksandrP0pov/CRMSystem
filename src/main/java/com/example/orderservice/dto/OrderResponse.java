package com.example.orderservice.dto;

import com.example.orderservice.entity.ProductCounter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private ProductCounter productCounter;
    private String message;
}
