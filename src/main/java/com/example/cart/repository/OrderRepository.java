package com.example.cart.repository;

import com.example.cart.model.Order;
import com.example.cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
