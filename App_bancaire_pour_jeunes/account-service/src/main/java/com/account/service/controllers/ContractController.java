package com.account.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.service.dtos.ContractDto;

import com.account.service.services.ContractService;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {
	
	
	@Autowired
	private ContractService contractService;
	
	public ContractController(ContractService contractService) {
		
		this.contractService = contractService;
	}
	
	@PostMapping("/newContract")
    public ResponseEntity<ContractDto> CreateContract(@RequestBody ContractDto contract) {

		ContractDto NewContract = contractService.CreateContract(contract.getContract_type_name(), contract.getCustomer_cin());
        return new ResponseEntity<>(NewContract, HttpStatus.CREATED);
    }
	
	
	
	
	

}
