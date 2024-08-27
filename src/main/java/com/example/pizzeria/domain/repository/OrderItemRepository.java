package com.example.pizzeria.domain.repository;

import com.example.pizzeria.domain.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository {

    List<OrderItem> findAll();

    Optional<OrderItem> findById(int id);

    OrderItem save(OrderItem orderItem);

    boolean edit(OrderItem orderItem);

    void deleteById(int id);
}
