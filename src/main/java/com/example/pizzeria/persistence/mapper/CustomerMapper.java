package com.example.pizzeria.persistence.mapper;

import com.example.pizzeria.domain.Customer;
import com.example.pizzeria.persistence.entity.Cliente;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mappings({
        @Mapping(source = "idCliente", target = "idCustomer"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "direccion", target = "address"),
        @Mapping(source = "correoElectronico", target = "email"),
        @Mapping(source = "numeroTelefono", target = "phoneNumber")
    })
    Customer toCustomer(Cliente cliente);

    List<Customer> toCustomers(List<Cliente> clientes);

    @InheritInverseConfiguration
    Cliente toCliente(Customer customer);
}

