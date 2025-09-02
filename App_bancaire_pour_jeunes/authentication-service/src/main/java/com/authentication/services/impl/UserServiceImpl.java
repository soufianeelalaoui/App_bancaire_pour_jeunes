package com.authentication.services.impl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.authentication.entities.RoleEntity;
import com.authentication.entities.UserEntity;
import com.authentication.repositories.RoleRepository;
import com.authentication.repositories.UserRepository;
import com.authentication.services.UserService;



@Service
@Transactional
@Qualifier("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(
        UserRepository userRepository,
        BCryptPasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity register(String activated_code, String username,String password,String confirmPassword) {
    	UserEntity userExist = userRepository.findByUsername(username);
    	//check user if is exist
    	if(userExist != null) throw new RuntimeException("Username exixte !!");
    	//check passwords
    	if(!password.equals(confirmPassword)) throw new RuntimeException("les deux mot de pass sant pas equal !!");
    	
    	UserEntity user = new UserEntity();
            user.setActivatedCode(activated_code);
            user.setUsername(username);
            user.setEnable(true);
            user.setPassword(encodePassword(password));
            user.setCreated_date(new Date());
            userRepository.save(user);
            addRoleToUser(user.getUsername(),"USER");
            return user;
    }

    @Override
    public List<UserEntity> getUsers() {
       
       return userRepository.findAll();
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
	public void addRoleToUser(String username, String nomRole) {
		UserEntity appUser = userRepository.findByUsername(username);
		RoleEntity appRole = roleRepository.findByName(nomRole);
		appUser.addRole(appRole);
		
	}

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username);;
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(
            r -> authorities.add(new SimpleGrantedAuthority(r.getName()))
        );
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

	@Override
	public String askCodeBBM() {
		// String username, String phoneNumber, String CIN
		  return getRandomNumberString();
	}
	
	public static String getRandomNumberString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    return String.format("%06d", number);
	}

    
}
