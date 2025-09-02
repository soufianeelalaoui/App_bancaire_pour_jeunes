package com.account.service.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "campany_types")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class CampanyTypeEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private String campany_type_name;

	@Column(nullable = false)
	private String campany_type_code;
	
	@Column(nullable = false)
	private int campany_type_rank;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCampany_type_name() {
		return campany_type_name;
	}

	public void setCampany_type_name(String campany_type_name) {
		this.campany_type_name = campany_type_name;
	}

	public String getCampany_type_code() {
		return campany_type_code;
	}

	public void setCampany_type_code(String campany_type_code) {
		this.campany_type_code = campany_type_code;
	}

	public int getCampany_type_rank() {
		return campany_type_rank;
	}

	public void setCampany_type_rank(int campany_type_rank) {
		this.campany_type_rank = campany_type_rank;
	}

	
	
	
	
	
	
	
	

}
