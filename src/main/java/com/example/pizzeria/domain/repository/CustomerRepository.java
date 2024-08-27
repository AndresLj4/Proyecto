package com.example.pizzeria.domain.repository;

import com.example.pizzeria.persistence.entity.Cliente;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    public List<Cliente> findByIdCliente(int idCliente);

    public Optional<Cliente> findByPhoneNumber(String phoneNumber);

    public List<Cliente> findByName(String name);

    public Optional<Cliente> getCustomer(int idCliente);

    public Cliente save(Cliente cliente);

    public boolean edit(Cliente cliente);

    public void delete(int idCliente);

    public List<Cliente> findAll();
    
}
