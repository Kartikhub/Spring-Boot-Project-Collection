package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class AccountController {
	@Autowired
	private AccountRepository employeeRepo;
	
	@PostMapping(value = "/")
	public ResponseEntity<?> addEmployee(@RequestBody Account employee){
		Account save = this.employeeRepo.save(employee);
		return ResponseEntity.ok(save);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<?> getEmployees(){
		return ResponseEntity.ok(this.employeeRepo.findAll());
	}
}
