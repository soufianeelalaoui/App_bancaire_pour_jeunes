package com.account.service.services.implementations;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.service.dtos.CustomerDto;
import com.account.service.entities.CampanyEntity;
import com.account.service.entities.CustomerEntity;
import com.account.service.entities.CustomerTypeEntity;
import com.account.service.entities.enumerations.CivilityEnum;
import com.account.service.entities.enumerations.SexeEnum;
import com.account.service.repositories.CampanyRepository;
import com.account.service.repositories.CustomerRepository;
import com.account.service.repositories.CustomerTypeRepository;
import com.account.service.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerTypeRepository customerTypeRepository;
	
	@Autowired
	private CampanyRepository campanyRepository;
	
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		
		super();
		this.customerRepository = customerRepository;
		
	}
	
	
	@Override
	public List<CustomerEntity> getAllCustomers() {
		
		return customerRepository.findAll();
	}
	@Override
	public CustomerEntity getCustomerByCin(String Cin) {
		
		return customerRepository.findByCustomer_cin(Cin);
	}
	
	
	@Override
	public CustomerDto CreateCustomer(String First_name, String Last_name, String Cin, Date birthday, SexeEnum sexe, CivilityEnum civility, String type, String campany) {
		
		CustomerEntity customer = customerRepository.findByCustomer_cin(Cin);
		CustomerTypeEntity customer_type = customerTypeRepository.findByCustomer_type_name(type);
		CampanyEntity campany_name = campanyRepository.findByCampany_name(campany);
		
		if(customer != null) throw new RuntimeException("customer Already exist exist !!");
		if(customer_type == null) throw new RuntimeException("Customer type doesn't exist !!");
		if(campany_name == null) throw new RuntimeException("campany doesn't exist !!");
			
			CustomerEntity newCustomer = new CustomerEntity();
			
			newCustomer.setCustomer_first_name(First_name);
			newCustomer.setCustomer_last_name(Last_name);
			newCustomer.setCustomer_cin(Cin);
			newCustomer.setCustomer_birthday(birthday);
			newCustomer.setCustomer_sexe(sexe);
			newCustomer.setCustomer_civility(civility);
			newCustomer.setCustomer_type(customer_type);
			newCustomer.setCampany(campany_name);
			customerRepository.save(newCustomer);
			return mapToCustomerDto(newCustomer);		
	}
	
    private CustomerDto mapToCustomerDto(CustomerEntity customer) {
		
		
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomer_first_name(customer.getCustomer_first_name());
		customerDto.setCustomer_last_name(customer.getCustomer_last_name());
		customerDto.setCustomer_cin(customer.getCustomer_cin());
		customerDto.setCustomer_birthday(customer.getCustomer_birthday());
		customerDto.setCustomer_sexe(customer.getCustomer_sexe());
		customerDto.setCustomer_civility(customer.getCustomer_civility());
		customerDto.setCustomer_type_name(customer.getCustomer_type().getCustomer_type_name());
		customerDto.setCampany_name(customer.getCampany().getCampany_name());
	    
	    return customerDto;
	}
	
	
	
}
