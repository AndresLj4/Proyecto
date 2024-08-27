package com.example.pizzeria.domain.service;

import com.example.pizzeria.domain.PizzaOrder;
import com.example.pizzeria.domain.repository.PizzaOrderRepository;
import com.example.pizzeria.persistence.mapper.PizzaOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaOrderService {

    @Autowired
    private PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    private PizzaOrderMapper pizzaOrderMapper;

    public List<PizzaOrder> findAll() {
        return pizzaOrderRepository.findAll();
    }

    public Optional<PizzaOrder> findById(int id) {
        return pizzaOrderRepository.findById(id);
    }

    public PizzaOrder save(PizzaOrder pizzaOrder) {
        return pizzaOrderRepository.save(pizzaOrder);
    }

    public boolean edit(PizzaOrder pizzaOrder) {
        return pizzaOrderRepository.edit(pizzaOrder);
    }

    public void deleteById(int id) {
        pizzaOrderRepository.deleteById(id);
    }
}
