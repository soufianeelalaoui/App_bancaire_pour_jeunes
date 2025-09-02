package com.account.service.dtos;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContractDto {
	
	private Long id;
	private String contract_type_name;
	private String customer_cin;
	private String contract_identifier;

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContract_identifier() {
		return contract_identifier;
	}

	public void setContract_identifier(String contract_identifier) {
		this.contract_identifier = contract_identifier;
	}

	public String getContract_type_name() {
		return contract_type_name;
	}

	public void setContract_type_name(String contract_type_name) {
		this.contract_type_name = contract_type_name;
	}

	public String getCustomer_cin() {
		return customer_cin;
	}

	public void setCustomer_cin(String customer_cin) {
		this.customer_cin = customer_cin;
	}
	
	
	


}
