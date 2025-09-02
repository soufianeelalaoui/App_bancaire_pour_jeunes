package com.authentication.configuration;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.authentication.jwt.AuthenticationFilter;
import com.authentication.jwt.AuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	   
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        super.configure(auth);
	    }
	    @Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http.csrf().disable().cors().disable();
	        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        http.authorizeRequests().antMatchers("/login","/api/v1/users/register","/api/v1/users/askCodeBBM").permitAll()
	        .and().authorizeRequests().anyRequest().authenticated();

	        http.addFilter(new AuthenticationFilter(authenticationManagerBean()));
	        http.addFilterBefore(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

	    }
	    
}
