package com.brujula.application.repository;

import java.util.List;

import com.brujula.domain.Customer;

public interface CustomerRepository {
    Customer getCustomer(Long id);
    
    Customer save(Customer customer);
    
    Customer update(Customer customer);
    
    List<Customer> getAll();
}
