package com.example.orderservice.controller;

import com.example.orderservice.dto.ProductCounterDto;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.entity.ProductCounter;
import com.example.orderservice.service.ProductCounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/count")
public class ProductCounterController {

    private final ProductCounterService productCounterService;

    @GetMapping
    public ResponseEntity<List<ProductCounter>> getAllOrders() {
        return new ResponseEntity<>(productCounterService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCounterDto> getOrderById(@PathVariable Long id) {
        return new ResponseEntity<>(productCounterService.getOrderDto(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductCounter> updateOrder(@RequestBody ProductCounter productCounter){
        return new ResponseEntity<>(productCounterService.updateOrder(productCounter), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteOrder(@PathVariable Long id){
        productCounterService.deleteOrder(id);
        return HttpStatus.OK;
    }

    @PostMapping("/add")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody ProductCounterDto productCounterDto){
        return new ResponseEntity<>(productCounterService.createOrder(productCounterDto), HttpStatus.OK);
    }
}
