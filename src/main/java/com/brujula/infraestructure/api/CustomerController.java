package com.brujula.infraestructure.api;

import com.brujula.application.service.CustomerService;
import com.brujula.domain.Customer;
import com.brujula.infraestructure.api.dto.CustomerDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
@RequestMapping("/customers")
public class CustomerController {
    
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get All Customer", notes = "Use this operation to get all customer")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operation OK")
    })
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Customer By Id", notes = "Use this operation to get a customer by Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operation OK"),
        @ApiResponse(code = 202, message = "Operation UNSUCCESSFULLY")
    })
    public ResponseEntity<CustomerDto> get(@ApiParam(value = "Customer Id", required = true) @PathVariable Long id) {
        return ResponseEntity.ok(CustomerDto.createCustomerDto(customerService.get(id)));
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save Customer", notes = "Use this operation to save a customer")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operation OK"),
        @ApiResponse(code = 202, message = "Operation UNSUCCESSFULLY")
    })
    public ResponseEntity<CustomerDto> save(@RequestBody @Valid CustomerDto customerDto) {
        return ResponseEntity.ok(CustomerDto.createCustomerDto(customerService.save(Customer.createCustomerDto(customerDto))));
    }
    
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Customer", notes = "Use this operation to update a customer")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operation OK"),
        @ApiResponse(code = 202, message = "Operation UNSUCCESSFULLY")
    })
    public ResponseEntity<CustomerDto> update(@RequestBody @Valid CustomerDto customerDto) {
        return ResponseEntity.ok(CustomerDto.createCustomerDto(customerService.update(Customer.createCustomerDto(customerDto))));
    }
}
