package com.brujula.application.service;

import com.brujula.application.repository.CustomerRepository;
import com.brujula.domain.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAll() {
        return repository.getAll();
    }
    
    public Customer get(Long id) {
        return repository.getCustomer(id);
    }
    
    public Customer save(Customer customer) {
        return repository.save(customer);
    }
    
    public Customer update(Customer customer) {
        return repository.update(customer);
    }
       
}
