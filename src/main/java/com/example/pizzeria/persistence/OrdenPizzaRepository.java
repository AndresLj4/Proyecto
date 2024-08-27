package com.example.pizzeria.persistence;

import com.example.pizzeria.domain.PizzaOrder;
import com.example.pizzeria.domain.repository.PizzaOrderRepository;
import com.example.pizzeria.persistence.crud.OrdenPizzaCrudRepository;
import com.example.pizzeria.persistence.entity.OrdenPizza;
import com.example.pizzeria.persistence.mapper.PizzaOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrdenPizzaRepository implements PizzaOrderRepository {

    @Autowired
    private OrdenPizzaCrudRepository ordenPizzaCrudRepository;

    @Autowired
    private PizzaOrderMapper pizzaOrderMapper;

    @Override
    public List<PizzaOrder> findAll() {
        return pizzaOrderMapper.toPizzaOrders((List<OrdenPizza>) ordenPizzaCrudRepository.findAll());
    }

    public Optional<PizzaOrder> findById(int id) {
        return ordenPizzaCrudRepository.findById(id)
                .map(pizzaOrderMapper::toPizzaOrder);
    }

    @Override
    public PizzaOrder save(PizzaOrder pizzaOrder) {
        OrdenPizza ordenPizzaEntity = pizzaOrderMapper.toOrdenPizza(pizzaOrder);
        return pizzaOrderMapper.toPizzaOrder(ordenPizzaCrudRepository.save(ordenPizzaEntity));
    }

    @Override
    public boolean edit(PizzaOrder pizzaOrder) {
        OrdenPizza ordenPizzaEntity = pizzaOrderMapper.toOrdenPizza(pizzaOrder);
        if (ordenPizzaCrudRepository.existsById(ordenPizzaEntity.getIdOrden())) {
            ordenPizzaCrudRepository.save(ordenPizzaEntity);
            return true;
        }
        return false;
    }

    @Override
    public void deleteById(int id) {
        ordenPizzaCrudRepository.deleteById(id);
    }
}
