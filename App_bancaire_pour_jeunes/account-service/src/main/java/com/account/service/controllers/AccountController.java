package com.account.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.service.dtos.AccountDto;
import com.account.service.services.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping("/newAccount")
    public ResponseEntity<AccountDto> CreateContract(@RequestBody AccountDto account) {

		AccountDto NewAccount = accountService.CreateAccount(account.getPhone_number(), account.getCustomer_cin());
        return new ResponseEntity<>(NewAccount, HttpStatus.CREATED);
    }
	
	/*@GetMapping("/AllAccounts")
	public List<AccountEntity> getAllAccounts(){
		return accountService.getAllAccounts();
	}*/
	
	@GetMapping("/AccountByCustomer")
	public List<AccountDto> getAllAccountsByCustomer(String customerId){
		return accountService.getAllAccountsByCustomer(customerId);
	}

}
