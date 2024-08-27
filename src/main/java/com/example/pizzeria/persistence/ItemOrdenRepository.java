package com.example.pizzeria.persistence;

import com.example.pizzeria.domain.OrderItem;
import com.example.pizzeria.domain.repository.OrderItemRepository;
import com.example.pizzeria.persistence.crud.OrderItemCrudRepository;
import com.example.pizzeria.persistence.entity.ItemOrden;
import com.example.pizzeria.persistence.mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ItemOrdenRepository implements OrderItemRepository {

    @Autowired
    private OrderItemCrudRepository orderItemCrudRepository;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItem> findAll() {
        List<ItemOrden> items = (List<ItemOrden>) orderItemCrudRepository.findAll();
        return orderItemMapper.toOrderItems(items);
    }

    @Override
    public Optional<OrderItem> findById(int id) {
        return orderItemCrudRepository.findById(id)
                .map(orderItemMapper::toOrderItem);
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        ItemOrden itemOrden = orderItemMapper.toItemOrden(orderItem);
        return orderItemMapper.toOrderItem(orderItemCrudRepository.save(itemOrden));
    }

    @Override
    public boolean edit(OrderItem orderItem) {
        if (orderItemCrudRepository.existsById(orderItem.getId())) {
            ItemOrden itemOrden = orderItemMapper.toItemOrden(orderItem);
            orderItemCrudRepository.save(itemOrden);
            return true;
        }
        return false;
    }

    @Override
    public void deleteById(int id) {
        orderItemCrudRepository.deleteById(id);
    }
}
