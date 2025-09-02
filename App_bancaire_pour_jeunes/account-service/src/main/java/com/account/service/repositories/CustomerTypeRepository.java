package com.account.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.account.service.entities.CustomerTypeEntity;



public interface CustomerTypeRepository extends JpaRepository<CustomerTypeEntity, Long>{

	@Query("FROM customer_types WHERE customer_type_name = :customer_type_name")	
    CustomerTypeEntity findByCustomer_type_name(String customer_type_name);	
}
