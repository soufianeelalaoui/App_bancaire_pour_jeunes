package com.account.service.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "campanies")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CampanyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable = false)
	private String campany_name;
	
	@ManyToOne
	@JoinColumn(name = "campany_type")
	private CampanyTypeEntity campany_type;
	
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private CityEntity city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CampanyTypeEntity getCampany_type() {
		return campany_type;
	}

	public void setCampany_type(CampanyTypeEntity campany_type) {
		this.campany_type = campany_type;
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = city;
	}

	public String getCampany_name() {
		return campany_name;
	}

	public void setCampany_name(String campany_name) {
		this.campany_name = campany_name;
	}
	
	
	
    
	
	
}
