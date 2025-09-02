package com.authentication.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest{
	
       private String username;
       private String password;
       private String confirmedPassword;
       private String fullName;
       private String firstName;
       private String lastName;
       private String activatedCode;
       
}
