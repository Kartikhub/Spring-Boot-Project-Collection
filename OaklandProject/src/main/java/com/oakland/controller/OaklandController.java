package com.oakland.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.oakland.entity.Employee;
import com.oakland.request.EmployeeDetailsReq;
import com.oakland.response.ErrorResponse;
import com.oakland.service.OaklandService;


import net.sf.jasperreports.engine.JRException;

@RestController
public class OaklandController {
	@Autowired
	OaklandService oaklandService;
	
	
	@GetMapping(value = "/employeeReport")
	public List<Employee> generateReport() throws FileNotFoundException, JRException {
		return oaklandService.exportReport();	
	}
	//Swagger
	@PostMapping(value = "/registerEmployee")
	public ErrorResponse registerEmployee(@RequestBody Employee employee) throws IOException {
		ErrorResponse errorResponse;
		try {
			errorResponse = new ErrorResponse();
		} catch (Exception e) {
			e.printStackTrace();
		}
			errorResponse = oaklandService.saveEmployeeDetails(employee) ;		
		return errorResponse;
	} 
	//Swagger
	@PostMapping(value = "/loginEmployee")
	public ErrorResponse loginUser(@RequestBody EmployeeDetailsReq employeeDetailsReq) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse = oaklandService.loginEmployee(employeeDetailsReq);
		return errorResponse;
	}
	//Swagger
	@GetMapping(value = "/getEmployeeList")
	public ErrorResponse getEmployeeList() {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse = oaklandService.getEmployeeList() ;
		return errorResponse;
	}  
	//JSP
	@GetMapping(value = "/employeeList")
	public String getEmployee(Model model){
		model.addAttribute("employees", oaklandService.getEmployeeDetails());
		return "view-employees";
	}
	
	@GetMapping("/addEmployee")
    public String addEmployeeView(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/addEmployee")
    public RedirectView addEmployee(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/addEmployee", true);
        
        Employee savedEmployee = oaklandService.addEmployee(employee);
        redirectAttributes.addFlashAttribute("savedEmployee", savedEmployee);
        redirectAttributes.addFlashAttribute("addEmployeeSuccess", true);
        return redirectView;
    } 
    
    @GetMapping("/logEmployee")
    public String logEmployeeView(Model model) {
        model.addAttribute("employeeDetailsReq", new EmployeeDetailsReq());
        return "log-employee";
    }

    @PostMapping("/logEmployee")
    public RedirectView logEmployeeView(@ModelAttribute("employeeDetailsReq") EmployeeDetailsReq employeeDetailsReq, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/logEmployee", true);
        
        Employee savedEmployee = oaklandService.logEmployee(employeeDetailsReq);
        redirectAttributes.addFlashAttribute("logEmployee", savedEmployee);
        redirectAttributes.addFlashAttribute("logEmployeeSuccess", true);
        return redirectView;
    } 

}
