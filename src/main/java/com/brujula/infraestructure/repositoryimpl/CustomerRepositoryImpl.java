package com.brujula.infraestructure.repositoryimpl;

import com.brujula.application.repository.CustomerRepository;
import com.brujula.domain.Customer;
import com.brujula.infraestructure.api.constant.StatusCode;
import com.brujula.infraestructure.api.handler.exception.CustomerNotFoundException;
import com.brujula.infraestructure.repositoryimpl.models.CustomerModel;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	
	
	@Autowired
	private CustomerDataRepository customerRepository;
	
	
	@Override
    public Customer getCustomer(Long id) {

	    return Customer.createCustomerModel(customerRepository.findById(id).orElseThrow(
	    		() -> new CustomerNotFoundException(StatusCode.NOT_FOUND.getDescription())));
		
    }

	@Override
	public Customer save(Customer customer) {
		CustomerModel customerModel = customerRepository.save(CustomerModel.createCustomerModel(customer));
		return Customer.createCustomerModel(customerModel);
	}


	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll().stream().map(customer ->new Customer(customer.getId(),customer.getFirstName(),
				customer.getLastName(),customer.getCompany())).collect(Collectors.toList());
	}


	@Override
	public Customer update(Customer customer) {
		CustomerModel customerModel = customerRepository.findById(customer.getId()).orElseThrow(
	    		() -> new CustomerNotFoundException(StatusCode.NOT_FOUND.getDescription()));
		
		customerModel.setFirstName(customer.getFirstName());
		customerModel.setLastName(customer.getLastName());
		customerModel.setCompany(customer.getCompany());
		
		return Customer.createCustomerModel(customerRepository.save(customerModel));
	}
}
