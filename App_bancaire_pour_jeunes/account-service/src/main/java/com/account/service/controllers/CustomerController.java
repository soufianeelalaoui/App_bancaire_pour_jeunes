package com.account.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.account.service.dtos.CustomerDto;
import com.account.service.services.CustomerService;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
    public CustomerController(CustomerService customerService) {
		
		this.customerService = customerService;
	}
	
    @PostMapping("/newCustomer")
    public ResponseEntity<CustomerDto> CreateContract(@RequestBody CustomerDto customer) {

    	CustomerDto NewCustomer = customerService.CreateCustomer(customer.getCustomer_first_name(), customer.getCustomer_last_name(), customer.getCustomer_cin(), customer.getCustomer_birthday(), customer.getCustomer_sexe(), customer.getCustomer_civility(), customer.getCustomer_type_name(), customer.getCampany_name());
        return new ResponseEntity<>(NewCustomer, HttpStatus.CREATED);
    }
    
	

}
