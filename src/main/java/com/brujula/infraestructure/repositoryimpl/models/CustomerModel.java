package com.brujula.infraestructure.repositoryimpl.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.brujula.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "customers")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String company;
    
    public static CustomerModel createCustomerModel(Customer customer){
        return new CustomerModel(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getCompany());
    }
    
}
