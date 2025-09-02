package com.authentication.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.authentication.configuration.SecuritySetting;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {


    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        if(httpServletRequest.getServletPath().equals("/login") 
        		|| httpServletRequest.getServletPath().equals("/api/v1/users/register")
        		|| httpServletRequest.getServletPath().equals("/api/v1/users/askCodeBBM")){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }else {
            String authentication_header = httpServletRequest.getHeader(SecuritySetting.AUTH_HEADER);
            if (authentication_header != null && authentication_header.startsWith(SecuritySetting.PREFIX)){

                try {
                    String jwtToken = authentication_header.substring(SecuritySetting.PREFIX.length());
                    Algorithm algorithm = Algorithm.HMAC256(SecuritySetting.SECRET);
                    JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                    DecodedJWT decodedJWT = jwtVerifier.verify(jwtToken);
                    String username = decodedJWT.getSubject();
                    List<String> roles = decodedJWT.getClaim("roles").asList(String.class); 
            		Collection<GrantedAuthority> authorities = new ArrayList<>();
            		
            		roles.forEach(rn->{
            			authorities.add(new SimpleGrantedAuthority(rn));
            		});

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(username, null,authorities);
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    filterChain.doFilter(httpServletRequest,httpServletResponse);
                } catch (Exception e) {
                    httpServletResponse.setHeader("error", e.getMessage());
                    httpServletResponse.sendError(httpServletResponse.SC_FORBIDDEN);
                }
            } else {
                filterChain.doFilter(httpServletRequest,httpServletResponse);
            }
        }
    }
}
