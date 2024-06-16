package com.oakland.response;

public class EmployeeDetailsResponse extends ErrorResponse{
	
	private String employeeName;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

}
