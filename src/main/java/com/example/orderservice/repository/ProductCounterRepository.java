package com.example.orderservice.repository;

import com.example.orderservice.entity.ProductCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCounterRepository extends JpaRepository<ProductCounter, Long> {
}
