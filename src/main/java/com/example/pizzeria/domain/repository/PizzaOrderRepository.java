package com.example.pizzeria.domain.repository;

import com.example.pizzeria.domain.PizzaOrder;

import java.util.List;
import java.util.Optional;

public interface PizzaOrderRepository {

    List<PizzaOrder> findAll();

    Optional<PizzaOrder> findById(int id);

    PizzaOrder save(PizzaOrder pizzaOrder);

    boolean edit(PizzaOrder pizzaOrder);

    void deleteById(int id);
}
