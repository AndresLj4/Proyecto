package com.example.pizzeria.persistence.crud;

import com.example.pizzeria.persistence.entity.OrdenPizza;
import org.springframework.data.repository.CrudRepository;

public interface OrdenPizzaCrudRepository extends CrudRepository<OrdenPizza, Integer> {
    
}
