package com.account.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.account.service.entities.CustomerEntity;


public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
	
	   
	   @Query("FROM customers WHERE customer_cin = :CIN")	
       CustomerEntity findByCustomer_cin(String CIN);	

}
