package com.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.entity.ApplicationUser;

public interface SecurityRepo extends JpaRepository<ApplicationUser, Integer>{
	ApplicationUser findByUsername(String username);
}
