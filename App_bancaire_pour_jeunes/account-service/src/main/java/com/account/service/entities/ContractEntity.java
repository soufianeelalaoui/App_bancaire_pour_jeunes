package com.account.service.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "contracts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ContractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "contract_type")
	private ContractTypeEntity contract_type;
	
	@OneToOne
	@JoinColumn(name = "account")
    private AccountEntity account;
	
	@Column(nullable = false)
	private String contract_identifier;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ContractTypeEntity getContract_type() {
		return contract_type;
	}

	public void setContract_type(ContractTypeEntity contract_type) {
		this.contract_type = contract_type;
	}

	public AccountEntity getAccount_() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	public String getContract_identifier() {
		return contract_identifier;
	}

	public void setContract_identifier(String contract_identifier) {
		this.contract_identifier = contract_identifier;
	}
	
	
	
	

}
