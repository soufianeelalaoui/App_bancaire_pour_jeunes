package com.authentication.dtos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.authentication.entities.RoleEntity;
import com.authentication.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
	
	private int id;
	
	private String pkid_user;
	
	private int agency_id;
	
	private String username;
	
	private Collection<RoleEntity> roles = new ArrayList<RoleEntity>();
	
	private String first_name;
	
	private String last_name;
	
	private String password;
	
	private Date birthday;
	
	private Date created_date;
	
	private Boolean enable;
	
	private String fullName;
	
	private String phone_number;
	
	private String account_number;
	
	private String activatedCode;
	
	/**
	 * 
	 * @param UserEntity
	 * @return entityToDto
	 */
	public static UserDto entityToDto(UserEntity userEntity) {
		UserDto userDto = new UserDto();
		if (userDto != null) {
			userDto.setId(userEntity.getId());;
			userDto.setPkid_user(userEntity.getPkid_user());
			userDto.setUsername(userEntity.getUsername());
			userDto.setRoles(userEntity.getRoles());
			userDto.setFirst_name(userEntity.getFirst_name());
			userDto.setLast_name(userEntity.getLast_name());
			userDto.setPassword(userEntity.getPassword());
			userDto.setBirthday(userEntity.getBirthday());
			userDto.setCreated_date(userEntity.getCreated_date());
			userDto.setEnable(userEntity.getEnable());
			userDto.setFullName(userEntity.getFullName());
			userDto.setPhone_number(userEntity.getPhone_number());
			userDto.setAccount_number(userEntity.getAccount_number());
			userDto.setActivatedCode(userEntity.getActivatedCode());
		}
		return userDto;
	}
	
	/**
	 * 
	 * @param listFormationentity
	 * @return entitiesToDtos
	 */
	public static List<UserDto> entitiesToDtos(List<UserEntity> listUserEntity) {
		List<UserDto> listUserDto = new ArrayList<>();
		if (!CollectionUtils.isEmpty(listUserEntity)) {
			for (UserEntity entity : listUserEntity) {
				listUserDto.add(entityToDto(entity));
			}
		}
		return listUserDto;
	}
	
	/**
	 * 
	 * @param userDto
	 * @return dtoToEntity
	 */
	public static UserEntity dtoToEntity(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		if (userDto != null) {
			userEntity.setId(userDto.getId());;
			userEntity.setPkid_user(userDto.getPkid_user());
			userEntity.setUsername(userDto.getUsername());
			userEntity.setRoles(userDto.getRoles());
			userEntity.setFirst_name(userDto.getFirst_name());
			userEntity.setLast_name(userDto.getLast_name());
			userEntity.setPassword(userDto.getPassword());
			userEntity.setBirthday(userDto.getBirthday());
			userEntity.setCreated_date(userDto.getCreated_date());
			userEntity.setEnable(userDto.getEnable());
			userEntity.setFullName(userDto.getFullName());
			userEntity.setPhone_number(userDto.getPhone_number());
			userEntity.setAccount_number(userDto.getAccount_number());
			userEntity.setActivatedCode(userDto.getActivatedCode());
		}
		return userEntity;
	}
	
	/**
	 * 
	 * @param listUserDto
	 * @return dtosToEntities
	 */
	public static List<UserEntity> dtosToEntities(List<UserDto> listUserDto) {
		List<UserEntity> listUserEntity = new ArrayList<>();
		if (!CollectionUtils.isEmpty(listUserDto)) {
			for (UserDto dto : listUserDto) {
				listUserEntity.add(dtoToEntity(dto));
			}
		}
		return listUserEntity;
	}

}
