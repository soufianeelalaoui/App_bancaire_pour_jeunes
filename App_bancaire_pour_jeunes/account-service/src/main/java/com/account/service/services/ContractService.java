package com.account.service.services;

import java.util.List;

import com.account.service.dtos.ContractDto;
import com.account.service.entities.AccountEntity;
import com.account.service.entities.ContractEntity;
import com.account.service.entities.ContractTypeEntity;

public interface ContractService {
	
	List<ContractEntity> getAllContracts();
	
	ContractEntity getContractDetailsById(long id);
	
	ContractDto CreateContract(String contract_type_name, String customer_cin);

}
