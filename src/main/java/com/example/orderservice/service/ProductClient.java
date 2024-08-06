package com.example.orderservice.service;

import com.example.orderservice.dto.Product;
import com.example.orderservice.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/products/dto/{id}")
    Product getProduct(@PathVariable Long id);

    @GetMapping("/response/{id}")
    ProductResponse getProductResponse(@PathVariable Long id,@RequestParam int quantity);



}
