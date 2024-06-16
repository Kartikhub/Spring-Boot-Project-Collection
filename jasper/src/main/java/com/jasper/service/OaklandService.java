package com.jasper.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import com.jasper.entity.Employee;
import com.jasper.repository.EmployeeRepo;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class OaklandService {

	@Autowired
	EmployeeRepo employeeRepo;
	//JASPER
	public List<Employee> exportReport() throws FileNotFoundException, JRException {
		String path = "F:\\Java Programs";
		List<Employee> employees= employeeRepo.findAll();
		File file =ResourceUtils.getFile("classpath:employee.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("created by", "Kartik");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\employee.pdf");
		//return "report generated successfully"+path;
		return employees;
	}
	
}
