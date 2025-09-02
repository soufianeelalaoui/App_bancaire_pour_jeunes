package com.authentication.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.authentication.configuration.SecuritySetting;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Autowired
	private AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);
		return authenticationManager.authenticate(authenticationToken);
	}

	@Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

    	User user = (User) authResult.getPrincipal();
        List<String> roles = new ArrayList<>(); 
		
		authResult.getAuthorities().forEach(a->{
			roles.add(a.getAuthority());
		});
		
        Algorithm algorithm = Algorithm.HMAC256(SecuritySetting.SECRET);
        String accesstoken = JWT.create()
                            .withSubject(user.getUsername())
                            .withExpiresAt(new Date(System.currentTimeMillis()+SecuritySetting.EXPIRE_ACCESS_TOKEN))
                            .withIssuer(request.getRequestURL().toString())
                            .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                            .sign(algorithm);
        String refreshToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+SecuritySetting.EXPIRE_REFRESH_TOKEN))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);
        response.setHeader(SecuritySetting.AUTH_HEADER,accesstoken);
        HashMap<String,Object> idToken = new HashMap<>();
        idToken.put("access-Token", accesstoken);
        idToken.put("refresh-Token", refreshToken);
        idToken.put("expire-in", SecuritySetting.EXPIRE_ACCESS_TOKEN);
        idToken.put("token-type", "Bearer");

        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

        new ObjectMapper().writeValue(response.getOutputStream(),idToken);

    }
}
