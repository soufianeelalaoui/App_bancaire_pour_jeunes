package com.account.service.services;

import java.util.Date;
import java.util.List;

import com.account.service.dtos.CustomerDto;
import com.account.service.entities.CampanyEntity;
import com.account.service.entities.CustomerEntity;
import com.account.service.entities.CustomerTypeEntity;
import com.account.service.entities.enumerations.CivilityEnum;
import com.account.service.entities.enumerations.SexeEnum;

public interface CustomerService {
	
	CustomerDto CreateCustomer(String First_name, String Last_name, String Cin, Date birthday, SexeEnum sexe, CivilityEnum civility, String type, String campany);
	
	List<CustomerEntity> getAllCustomers();
	
	CustomerEntity getCustomerByCin(String Cin);
}
