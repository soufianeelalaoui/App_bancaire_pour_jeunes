package com.account.service.services.implementations;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.service.dtos.AccountDto;
import com.account.service.entities.AccountEntity;
import com.account.service.entities.CustomerEntity;
import com.account.service.repositories.AccountRepository;
import com.account.service.repositories.CustomerRepository;
import com.account.service.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		
		super();
		this.accountRepository = accountRepository ;
	}
	

	@Override
	public List<AccountDto> getAllAccountsByCustomer(String customerId) {
		
		return accountRepository.findAllAccountsByCustomer(customerId);
	}
	
	@Override
	public List<AccountEntity> getAllAccounts() {
		String message = "this is inside getAllAccounnts" ;
		List<AccountEntity> list = accountRepository.findAll();
		System.out.println(message);
		return list;
		

	}
	
	@Override
	public AccountDto CreateAccount(Long phone_number, String customer_cin) {
		
		AccountEntity newAccount = new AccountEntity();
		CustomerEntity customer = customerRepository.findByCustomer_cin(customer_cin);
		
		if(customer == null) throw new RuntimeException("customer doesn't exist !!");
		
		newAccount.setCreation_date(new Date());
		newAccount.setAccount_number(generateNumberAccount());
		newAccount.setPhone_number(phone_number);
		newAccount.setCustomer(customer);
		
		accountRepository.save(newAccount);
		return mapToAccountDto(newAccount);
	}
	
    public AccountDto mapToAccountDto(AccountEntity account) {
		
    	AccountDto accountDto = new AccountDto();
    	
    	accountDto.setCreation_date(account.getCreation_date());
    	accountDto.setAccount_number(account.getAccount_number());
    	accountDto.setPhone_number(account.getPhone_number());
    	accountDto.setCustomer_cin(account.getCustomer().getCustomer_cin());
	    
	    return accountDto;
	}
    
    public String generateNumberAccount() {
        Random rand = new Random();
        List<Integer> randomField = new ArrayList<>();
        int min = 0;
        int max = 9;
        int size = 30;
        
        for (int i = 0; i < size; i++) {
            randomField.add(rand.nextInt(max - min + 1) + min);
        }
        
        String number = listToString(randomField);
        
        // Check if the generated number already exists in the database
        while (accountRepository.findAccountByNumberAccount(number) != null) {
            // If it does, generate a new number
            randomField.clear();
            for (int i = 0; i < size; i++) {
                randomField.add(rand.nextInt(max - min + 1) + min);
            }
            number = listToString(randomField);
        }
        
        return number;
    }

    
    public String listToString(List<Integer> list) {
    	
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        return sb.toString();
    }
    
    
    

}
