package com.oakland.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;

import com.oakland.beans.ErrorCodes;
import com.oakland.entity.Employee;
import com.oakland.repository.EmployeeRepo;
import com.oakland.request.EmployeeDetailsReq;
import com.oakland.response.EmployeeDetailsResponse;
import com.oakland.response.EmployeeListResponse;
import com.oakland.response.ErrorResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



@Service
public class OaklandService {
	@Autowired
	EmployeeRepo employeeRepo;
	//JASPER
	public List<Employee> exportReport() throws FileNotFoundException, JRException {
		String path = "F:\\Java Programs\\Jasper Report";
		List<Employee> employees= employeeRepo.findAll();
		File file =ResourceUtils.getFile("classpath:employees.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("created by", "Kartik");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\employees.pdf");
		//return "report generated successfully"+path;
		return employees;
	}
	
	
	//JSP
	public List<Employee> getEmployeeDetails(){
		return employeeRepo.findAll();
	}
 
	public Employee addEmployee(@RequestBody Employee employee) {
		employeeRepo.save(employee);
		return employee;
	}
	
	public Employee logEmployee(@RequestBody EmployeeDetailsReq employeeDetailsReq) {
		Employee employee = employeeRepo.findByLoginIdAndPassword(employeeDetailsReq.getLoginId(), employeeDetailsReq.getPassword());
		if(employee == null) {
			return employee;
		}
		return employee;
	}
	//Swagger
	public ErrorResponse saveEmployeeDetails(Employee employee) throws IOException {
		ErrorResponse errorResponse= new ErrorResponse();
		try {
			employeeRepo.save(employee);
			errorResponse.setErrorCode(ErrorCodes.SUCCESS_CODE);
			errorResponse.setErrorMsg(ErrorCodes.SUCCESS_MSG);
		}
		catch (Exception e) {
			errorResponse.setErrorCode(ErrorCodes.INPUT_NOT_FOUND_CODE);
			errorResponse.setErrorMsg(ErrorCodes.INPUT_NOT_FOUND_MSG);
			e.printStackTrace();
		}
		return errorResponse;
	
	}
	//Swagger
	public ErrorResponse loginEmployee(EmployeeDetailsReq employeeDetailsReq) {
		EmployeeDetailsResponse employeeDetailsResponse = new EmployeeDetailsResponse();
		Employee employee = employeeRepo.findByLoginIdAndPassword(employeeDetailsReq.getLoginId(), employeeDetailsReq.getPassword());
		if(employee == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorCode(ErrorCodes.INVALID_REQUEST_ERROR_CODE);
			errorResponse.setErrorMsg(ErrorCodes.INVALID_REQUEST_ERROR_MSG);
			return errorResponse;
		}
		String employeeName = employee.getName();
		employeeDetailsResponse.setEmployeeName(employeeName);
		employeeDetailsResponse.setErrorCode(ErrorCodes.SUCCESS_CODE);
		employeeDetailsResponse.setErrorMsg(ErrorCodes.SUCCESS_MSG);
		return employeeDetailsResponse;
	}
	
	//Swagger
	public ErrorResponse getEmployeeList() {
		EmployeeListResponse employeeListResponse = new EmployeeListResponse();
		List<Employee> employeeList = employeeRepo.findAll();
		if(employeeList == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorCode(ErrorCodes.NO_EMPLOYEE_LIST_CODE);
			errorResponse.setErrorMsg(ErrorCodes.NO_EMPLOYEE_MSG);
			return errorResponse;
		}
		List<Employee> employeeResponseList = new ArrayList<>();
		for(Employee employee : employeeList) {
			Employee employeeResponse = new Employee();
			employeeResponse.setEmployeeId(employee.getEmployeeId());
			employeeResponse.setAddress(employee.getAddress());
			employeeResponse.setCity(employee.getCity());
			employeeResponse.setGender(employee.getGender());
			employeeResponse.setLoginId(employee.getLoginId());
			employeeResponse.setPassword(employee.getPassword());
			employeeResponse.setName(employee.getName());
			employeeResponse.setDob(employee.getDob());
			employeeResponse.setState(employee.getState());
			employeeResponseList.add(employeeResponse);
		}
		employeeListResponse.setEmployeeList(employeeResponseList); 
		employeeListResponse.setErrorCode(ErrorCodes.SUCCESS_CODE);
		employeeListResponse.setErrorMsg(ErrorCodes.SUCCESS_MSG);
		return employeeListResponse;
	}
}
