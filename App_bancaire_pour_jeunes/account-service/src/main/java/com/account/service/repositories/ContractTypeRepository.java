package com.account.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.account.service.entities.ContractTypeEntity;

public interface ContractTypeRepository extends JpaRepository<ContractTypeEntity, Long>{
	
	@Query("FROM contract_types WHERE contract_type_name = :contract_type_name")	
    ContractTypeEntity findByContract_type_name(String contract_type_name);	

}
