package com.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.dtos.UserDto;
import com.authentication.entities.UserEntity;
import com.authentication.model.request.UserRegisterRequest;
import com.authentication.services.UserService;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/api/v1/users")
public class SecurityController {
	@Autowired
	private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserRegisterRequest user) {
    	UserEntity newUser = userService.register(user.getActivatedCode(), user.getUsername(), user.getPassword(),user.getConfirmedPassword());
    	return new ResponseEntity(
    			UserDto.entityToDto(newUser),
				HttpStatus.OK);
    }
    @GetMapping("/allUsers")
    public ResponseEntity<UserDto> allUsers(){
    	return new ResponseEntity(UserDto.entitiesToDtos(userService.getUsers()), HttpStatus.OK);
    }
    @GetMapping("/askCodeBBM")
    public String askCodeBBM() {
    	// String username,String phoneNumber,String cin
    	return userService.askCodeBBM();
    }
}
