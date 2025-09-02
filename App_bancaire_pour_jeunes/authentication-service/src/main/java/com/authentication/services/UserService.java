package com.authentication.services;

import java.util.List;

import com.authentication.entities.UserEntity;

public interface UserService {
	

	UserEntity findUserByUsername(String username);

	UserEntity register(String activatedCode, String username,String password,String confirmPassword);

    List<UserEntity> getUsers();
    
    String askCodeBBM();
    //String username,String phoneNumber,String CIN
    
}
