package com.account.service.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "service_contract")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class OperationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "service_name")
	private OperationTypeEntity service_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OperationTypeEntity getService_name() {
		return service_name;
	}

	public void setService_name(OperationTypeEntity service_name) {
		this.service_name = service_name;
	}
	
	

}
