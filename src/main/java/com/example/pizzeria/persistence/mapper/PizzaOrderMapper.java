package com.example.pizzeria.persistence.mapper;

import com.example.pizzeria.domain.PizzaOrder;
import com.example.pizzeria.persistence.entity.OrdenPizza;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PizzaOrderMapper {

    @Mappings({
            @Mapping(source = "idOrden", target = "id"),
            @Mapping(source = "cliente.idCliente", target = "idCustomer"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "metodo", target = "method"),
            @Mapping(source = "notasAdicionales", target = "additionalNotes")
    })
    PizzaOrder toPizzaOrder(OrdenPizza ordenPizza);

    List<PizzaOrder> toPizzaOrders(List<OrdenPizza> ordenPizzas);

    @InheritInverseConfiguration
    OrdenPizza toOrdenPizza(PizzaOrder pizzaOrder);
}
