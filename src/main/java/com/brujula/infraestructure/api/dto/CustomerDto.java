package com.brujula.infraestructure.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.brujula.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

	private Long id;
	
	@NotBlank
	@Size(min = 10, max = 50)
    private String firstName;
    
	@NotBlank
	@Size(min = 10, max = 100)
    private String lastName;
    
    @NotBlank
    private String company;

    public static CustomerDto createCustomerDto(Customer customer){
        return new CustomerDto(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getCompany());
    }
}
