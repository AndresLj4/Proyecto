package com.example.pizzeria.persistence.controller;

import com.example.pizzeria.domain.PizzaOrder;
import com.example.pizzeria.domain.service.PizzaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class PizzaOrderController {

    @Autowired
    private PizzaOrderService pizzaOrderService;

    @GetMapping("/all")
    public ResponseEntity<List<PizzaOrder>> getAllOrders() {
        List<PizzaOrder> orders = pizzaOrderService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaOrder> getOrderById(@PathVariable int id) {
        Optional<PizzaOrder> order = pizzaOrderService.findById(id);
        return order.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<PizzaOrder> saveOrder(@RequestBody PizzaOrder pizzaOrder) {
        PizzaOrder savedOrder = pizzaOrderService.save(pizzaOrder);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaOrder> updateOrder(@PathVariable int id, @RequestBody PizzaOrder pizzaOrder) {
        pizzaOrder.setId(id);
        boolean updated = pizzaOrderService.edit(pizzaOrder);
        if (updated) {
            return new ResponseEntity<>(pizzaOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        pizzaOrderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
