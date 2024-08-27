package com.example.pizzeria.domain.service;

import com.example.pizzeria.domain.Customer;
import com.example.pizzeria.domain.repository.CustomerRepository;
import com.example.pizzeria.persistence.crud.ClienteCrudRepository;
import com.example.pizzeria.persistence.entity.Cliente;
import com.example.pizzeria.persistence.mapper.CustomerMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> findAll() {
        return customerMapper.toCustomers(customerRepository.findAll());
    }

    public List<Customer> findByIdCustomer(int idCustomer) {
        return customerMapper.toCustomers(customerRepository.findByIdCliente(idCustomer));
    }

    public Optional<Customer> findByPhoneNumber(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber)
                .map(customerMapper::toCustomer);
    }

    public List<Customer> findByName(String name) {
        return customerMapper.toCustomers(customerRepository.findByName(name));
    }

    public Optional<Customer> getCustomer(int idCustomer) {
        return customerRepository.getCustomer(idCustomer)
                .map(customerMapper::toCustomer);
    }

    public Customer save(Customer customer) {
        Cliente clienteEntity = customerMapper.toCliente(customer);
        return customerMapper.toCustomer(customerRepository.save(clienteEntity));
    }

    public boolean edit(Customer customer) {
        Cliente clienteEntity = customerMapper.toCliente(customer);
        return customerRepository.edit(clienteEntity);
    }

    public void deleteById(int idCustomer) {
        customerRepository.delete(idCustomer);
    }

}
