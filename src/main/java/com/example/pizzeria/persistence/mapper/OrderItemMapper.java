package com.example.pizzeria.persistence.mapper;

import com.example.pizzeria.domain.OrderItem;
import com.example.pizzeria.persistence.entity.ItemOrden;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    @Mappings({
            @Mapping(source = "idItem", target = "id"),
            @Mapping(source = "orden.idOrden", target = "idOrder"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "precio", target = "price"),
    })
    OrderItem toOrderItem(ItemOrden itemOrden);

    List<OrderItem> toOrderItems(List<ItemOrden> items);

    @InheritInverseConfiguration
    ItemOrden toItemOrden(OrderItem orderItem);
}
