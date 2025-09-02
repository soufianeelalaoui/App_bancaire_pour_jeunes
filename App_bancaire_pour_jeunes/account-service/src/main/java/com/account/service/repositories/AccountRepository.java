package com.account.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.account.service.dtos.AccountDto;
import com.account.service.entities.AccountEntity;



public interface AccountRepository extends JpaRepository<AccountEntity, Long>{
	
	@Query("FROM accounts WHERE customer.id = :customerId")
	List<AccountDto> findAllAccountsByCustomer(String customerId);
	
	@Query("FROM accounts WHERE account_number = :numberAccount")
    AccountDto findAccountByNumberAccount(String numberAccount);
	
	@Query("FROM accounts WHERE customer.customer_cin = :customer_cin")
	AccountEntity findAccountByCustomerCin(String customer_cin);
}
