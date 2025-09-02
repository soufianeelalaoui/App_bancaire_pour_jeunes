package com.account.service.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.account.service.entities.enumerations.CivilityEnum;
import com.account.service.entities.enumerations.SexeEnum;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(nullable = false)
	private String customer_first_name;
	
	@Column(nullable = false)
	private String customer_last_name;
	
	@Column(nullable = false)
	private String customer_cin;
    
	
	@Column(nullable = false)
	private Date customer_birthday;
	
	
	@Column(nullable = false)
    private SexeEnum customer_sexe;
	
	@Column(nullable = false)
	private CivilityEnum customer_civility;
	
	@ManyToOne
	@JoinColumn(name = "customer_type")
	private CustomerTypeEntity customer_type;

	
	@ManyToOne
	@JoinColumn(name = "campany_id")
	private CampanyEntity campany;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<AccountEntity> accounts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAccounts(List<AccountEntity> accounts) {
		this.accounts = accounts;
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

	public CustomerTypeEntity getCustomer_type() {
		return customer_type;
	}

	public void setCustomer_type(CustomerTypeEntity customer_type) {
		this.customer_type = customer_type;
	}

	public CampanyEntity getCampany() {
		return campany;
	}

	public void setCampany(CampanyEntity campany) {
		this.campany = campany;
	}

	public List<AccountEntity> getAccounts() {
		return accounts;
	}
	
	

	
	
	
	

}
