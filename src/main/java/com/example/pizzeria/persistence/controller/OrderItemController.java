package com.example.pizzeria.persistence.controller;

import com.example.pizzeria.domain.OrderItem;
import com.example.pizzeria.domain.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/all")
    public ResponseEntity<List<OrderItem>> getAll() {
        return new ResponseEntity<>(orderItemService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getById(@PathVariable("id") int id) {
        Optional<OrderItem> orderItem = orderItemService.findById(id);
        return orderItem.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<OrderItem> save(@RequestBody OrderItem orderItem) {
        return new ResponseEntity<>(orderItemService.save(orderItem), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> edit(@PathVariable("id") int id, @RequestBody OrderItem orderItem) {
        if (orderItemService.findById(id).isPresent()) {
            orderItem.setId(id);
            boolean edited = orderItemService.edit(orderItem);
            if (edited) {
                return new ResponseEntity<>(orderItem, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        orderItemService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
