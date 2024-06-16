package com.spring.security.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.entity.ApplicationUser;
import com.spring.security.repository.SecurityRepo;

@RestController
@RequestMapping("/users")
public class UserController {

	private SecurityRepo securityRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserController(SecurityRepo securityRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.securityRepo = securityRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@PostMapping("/record")
	public void signUp(@RequestBody ApplicationUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		securityRepo.save(user);
	}
}
