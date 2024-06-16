package com.jasper.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.jasper.entity.Employee;
import com.jasper.service.OaklandService;

import net.sf.jasperreports.engine.JRException;

public class OaklandController {
	@Autowired
	OaklandService oaklandService;
	
	
	@GetMapping(value = "/employeeReport")
	public String generateReport() throws FileNotFoundException, JRException {
		return "Hello";	
	}

}
