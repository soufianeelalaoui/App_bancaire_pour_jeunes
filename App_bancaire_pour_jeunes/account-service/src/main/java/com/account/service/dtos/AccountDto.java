package com.account.service.dtos;

import java.util.Date;

import com.account.service.entities.ContractEntity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDto {
	
	private Long id;
	private Date creation_date;
	private Long phone_number;
	private String account_number;
	private ContractEntity contract_id;
	private String customer_cin;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ContractEntity getContract_id() {
		return contract_id;
	}
	public void setContract_id(ContractEntity contract_id) {
		this.contract_id = contract_id;
	}
	public Long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getCustomer_cin() {
		return customer_cin;
	}
	public void setCustomer_cin(String customer_cin) {
		this.customer_cin = customer_cin;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	
	
	
	

}
