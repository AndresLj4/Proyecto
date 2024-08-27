package com.example.pizzeria.persistence.crud;

import com.example.pizzeria.persistence.entity.ItemOrden;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemCrudRepository extends CrudRepository<ItemOrden, Integer> {

}
