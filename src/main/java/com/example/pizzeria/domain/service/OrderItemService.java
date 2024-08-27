package com.example.pizzeria.domain.service;

import com.example.pizzeria.domain.OrderItem;
import com.example.pizzeria.domain.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> findById(int id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public boolean edit(OrderItem orderItem) {
        return orderItemRepository.edit(orderItem);
    }

    public void deleteById(int id) {
        orderItemRepository.deleteById(id);
    }
}
