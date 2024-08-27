package com.example.pizzeria.persistence.crud;

import com.example.pizzeria.persistence.entity.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface ClienteCrudRepository extends CrudRepository<Cliente, Integer>{
    
    List<Cliente> findByIdCliente(int idCliente);

    Cliente findByNumeroTelefono(String numeroTelefono);

    List<Cliente> findByNombre(String nombre);
}
