package com.account.service.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = true)
	private Date creation_date;
	
	@Column(nullable = false, length = 10)
	private Long phone_number;
	
	//RIB
	@Column(nullable = false)
	private String account_number;
	
	@OneToOne(mappedBy = "account", optional = true)
	private ContractEntity contract_identifier;
	
	@ManyToOne
	@JoinColumn(name = "customer")
	private CustomerEntity customer;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public ContractEntity getContract_identifier() {
		return contract_identifier;
	}

	public void setContract_identifier(ContractEntity contract_identifier) {
		this.contract_identifier = contract_identifier;
	}

	public Long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer_id) {
		this.customer = customer_id;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

   	
	
	
	
	
	

}
