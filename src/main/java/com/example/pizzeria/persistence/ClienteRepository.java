package com.example.pizzeria.persistence;

import com.example.pizzeria.domain.repository.CustomerRepository;
import com.example.pizzeria.persistence.crud.ClienteCrudRepository;
import com.example.pizzeria.persistence.entity.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository implements CustomerRepository {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Override
    public List<Cliente> findByIdCliente(int idCliente) {
        return clienteCrudRepository.findByIdCliente(idCliente);
    }

    @Override
    public Optional<Cliente> findByPhoneNumber(String numeroTelefono) {
        return Optional.ofNullable(clienteCrudRepository.findByNumeroTelefono(numeroTelefono));
    }

    @Override
    public List<Cliente> findByName(String nombre) {
        return clienteCrudRepository.findByNombre(nombre);
    }

    @Override
    public Optional<Cliente> getCustomer(int idCliente) {
        return clienteCrudRepository.findById(idCliente);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteCrudRepository.save(cliente);
    }

    @Override
    public boolean edit(Cliente cliente) {
        if (clienteCrudRepository.existsById(cliente.getIdCliente())) {
            clienteCrudRepository.save(cliente);
            return true;
        }
        return false;
    }

    @Override
    public void delete(int idCliente) {
        clienteCrudRepository.deleteById(idCliente);
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteCrudRepository.findAll();
    }

}
