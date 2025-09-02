package com.account.service.dtos;

import java.util.Date;
import java.util.List;
import com.account.service.entities.AccountEntity;
import com.account.service.entities.CampanyEntity;
import com.account.service.entities.CustomerTypeEntity;
import com.account.service.entities.enumerations.CivilityEnum;
import com.account.service.entities.enumerations.SexeEnum;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDto {
	
	
	private Long id;
	private String customer_first_name;
	private String customer_last_name;
	private String customer_cin;
	private Date customer_birthday;
	private SexeEnum customer_sexe;
	private CivilityEnum customer_civility;
	private String customer_type_name;
	private String campany_name;
	private List<AccountEntity> accounts;
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomer_first_name() {
		return customer_first_name;
	}
	public void setCustomer_first_name(String customer_first_name) {
		this.customer_first_name = customer_first_name;
	}
	public String getCustomer_cin() {
		return customer_cin;
	}
	public void setCustomer_cin(String customer_cin) {
		this.customer_cin = customer_cin;
	}
	public String getCustomer_last_name() {
		return customer_last_name;
	}
	public void setCustomer_last_name(String customer_last_name) {
		this.customer_last_name = customer_last_name;
	}
	public Date getCustomer_birthday() {
		return customer_birthday;
	}
	public void setCustomer_birthday(Date customer_birthday) {
		this.customer_birthday = customer_birthday;
	}
	public SexeEnum getCustomer_sexe() {
		return customer_sexe;
	}
	public void setCustomer_sexe(SexeEnum customer_sexe) {
		this.customer_sexe = customer_sexe;
	}
	public CivilityEnum getCustomer_civility() {
		return customer_civility;
	}
	public void setCustomer_civility(CivilityEnum customer_civility) {
		this.customer_civility = customer_civility;
	}
	
	public String getCustomer_type_name() {
		return customer_type_name;
	}
	public void setCustomer_type_name(String customer_type_name) {
		this.customer_type_name = customer_type_name;
	}
	public String getCampany_name() {
		return campany_name;
	}
	public void setCampany_name(String campany_name) {
		this.campany_name = campany_name;
	}
	public List<AccountEntity> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<AccountEntity> accounts) {
		this.accounts = accounts;
	}
	
	
	
	

	
	

    

}
