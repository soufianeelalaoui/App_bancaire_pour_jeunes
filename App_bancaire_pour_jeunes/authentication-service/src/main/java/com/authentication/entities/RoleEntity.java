package com.authentication.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity(name="Role")
@NoArgsConstructor
@ToString
@Getter 
@Setter
public class RoleEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "pkid_role",unique = true, nullable = false)
	private String pkid_role;
	
	@Column(name = "role_name", nullable = false)
	private String name;
	

	public Object stream() {
		// TODO Auto-generated method stub
		return null;
	}

	public RoleEntity(int id, String pkid_role, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.pkid_role = pkid_role;
		this.name = name;
	}
}
