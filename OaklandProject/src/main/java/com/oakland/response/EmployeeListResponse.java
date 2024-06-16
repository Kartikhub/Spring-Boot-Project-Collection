package com.oakland.response;

import java.util.List;

import com.oakland.entity.Employee;

public class EmployeeListResponse extends ErrorResponse{
	private List<Employee> employeeList;

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}


}
