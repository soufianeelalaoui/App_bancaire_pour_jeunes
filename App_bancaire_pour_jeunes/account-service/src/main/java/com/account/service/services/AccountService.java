package com.account.service.services;

import java.util.List;

import com.account.service.dtos.AccountDto;
import com.account.service.entities.AccountEntity;
import com.account.service.entities.ContractEntity;
import com.account.service.entities.CustomerEntity;

public interface AccountService {
	
	List<AccountDto> getAllAccountsByCustomer(String customerId);
	
	List<AccountEntity> getAllAccounts();
	
	AccountDto CreateAccount(Long phone_number, String customer_cin);

}
