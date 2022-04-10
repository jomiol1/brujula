package com.brujula.domain;

import com.brujula.infraestructure.api.dto.CustomerDto;
import com.brujula.infraestructure.repositoryimpl.models.CustomerModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    
	private Long id;
    private String firstName;
    private String lastName;
    private String company;
    
    public static Customer createCustomer(Long id, String firstName, String lastName, String company){
        return new Customer(id, firstName, lastName, company);
    }
    
    public static Customer createCustomerModel(CustomerModel customerModel){
        return new Customer(customerModel.getId(), customerModel.getFirstName(), customerModel.getLastName(), customerModel.getCompany());
    }
    
    public static Customer createCustomerDto(CustomerDto customerDto){
        return new Customer(customerDto.getId(), customerDto.getFirstName(), customerDto.getLastName(), customerDto.getCompany());
    }

}
