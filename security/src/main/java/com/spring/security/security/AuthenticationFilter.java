package com.spring.security.security;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.security.entity.ApplicationUser;

public class AuthenticationFilter extends UsernameNotFoundException{
	private AuthenticationManager authenticationManager;

	public AuthenticationFilter(String msg, AuthenticationManager authenticationManager) {
		super(msg);
		this.authenticationManager = authenticationManager;
	}
	
	
	public Authentication attemptAuthentication(HttpServletRequest req, 
												HttpServletResponse res) throws AuthenticationException {
		try {
			 ApplicationUser applicationUser = new ObjectMapper().readValue(req.getInputStream(), ApplicationUser.class);

	            return authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(applicationUser.getUsername(),
	                            applicationUser.getPassword(), new ArrayList()<>())
	            );
		}
			catch (BadCredentialsException notFoundException) {
				notFoundException.printStackTrace();
	    }  catch (Exception e) {
	       e.printStackTrace();
	    }
	}
}
