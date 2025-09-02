package com.authentication.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity(name="users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter 
@Setter

public class UserEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "pkid_user", nullable = true)
	private String pkid_user;
	
	@Column(name = "fkid_agency", nullable = true)
	private int agency_id;
	
	
	@Column(name = "identifier", nullable = true)
	private String username;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<RoleEntity> roles = new ArrayList<RoleEntity>();
	
	  public void addRole(RoleEntity role) {
	        this.roles.add(role);
	}
	
	@Column(name = "first_name", nullable = true)
	private String first_name;
	
	@Column(name = "last_name", nullable = true)
	private String last_name;
	
	@Column(name = "password", nullable = true)
	private String password;
	
	@Column(name = "birthday", nullable = true)
	private Date birthday;
	
	@Column(name = "created_date", nullable = true)
	private Date created_date;
	
	@Column(name = "enable", nullable = true)
	private Boolean enable;
	
	@Column(name = "fullName",nullable = true)
    private String fullName;
	
	@Column(name = "phone_number",nullable = true)
    private String phone_number;
	
	@Column(name = "account_number",nullable = true)
    private String account_number;
	
	@Column(name = "activatedCode",nullable = true)
    private String activatedCode;
	

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
