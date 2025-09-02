package com.account.service.services.implementations;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.service.entities.ContractEntity;
import com.account.service.entities.ContractTypeEntity;
import com.account.service.dtos.ContractDto;
import com.account.service.entities.AccountEntity;
import com.account.service.repositories.AccountRepository;
import com.account.service.repositories.ContractRepository;
import com.account.service.repositories.ContractTypeRepository;
import com.account.service.services.ContractService;

@Service
public class ContractServiceImpl implements ContractService {
	
	
	@Autowired
	private ContractRepository contractRepository;

	@Autowired
	private ContractTypeRepository contractTypeRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	public ContractServiceImpl(ContractRepository contractRepository) {
		
		super();
		this.contractRepository = contractRepository;
		
	}
	
	@Override
	public List<ContractEntity> getAllContracts() {
		
		return contractRepository.findAll();
		
	}
	
	
	@Override
	public ContractEntity getContractDetailsById(long id) {
	    Optional<ContractEntity> contract = contractRepository.findById(id);
	    return contract.orElse(null); // or throw an exception if necessary
	}

	
	
	@Override
    public ContractDto CreateContract(String contract_type_name, String customer_cin) {
		
		ContractEntity newContract = new ContractEntity();
		ContractTypeEntity contract_type = contractTypeRepository.findByContract_type_name(contract_type_name);
		AccountEntity account = accountRepository.findAccountByCustomerCin(customer_cin);
		
		if(contract_type == null) throw new RuntimeException("Contract type doesn't exist !!");
		if(account == null) throw new RuntimeException("Account doesn't exist !!");
		
		newContract.setContract_type(contract_type);
		newContract.setAccount(account);
		newContract.setContract_identifier(generateContractIdentifier());
		
		contractRepository.save(newContract);
	    return mapToContractDto(newContract);			
	}
	
	public String generateContractIdentifier() {
		
        Random rand = new Random();
        List<Integer> randomNumber = new ArrayList<>();
        int min = 0;
        int max = 9;
        int size = 12;
        
        for (int i = 0; i < size; i++) {
        	randomNumber.add(rand.nextInt(max - min + 1) + min);
        }

        return listToString(randomNumber);
    }
	
    public String listToString(List<Integer> list) {
    	
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        return sb.toString();
    }
	
	private ContractDto mapToContractDto(ContractEntity contract) {
		
		
		ContractDto contractDto = new ContractDto();
		
		contractDto.setContract_type_name(contract.getContract_type().getContract_type_name());
		contractDto.setCustomer_cin(contract.getAccount_().getCustomer().getCustomer_cin());
		contractDto.setContract_identifier(contract.getContract_identifier());
	    
	    return contractDto;
	}
	
	

}
