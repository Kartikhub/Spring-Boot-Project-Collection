package com.oakland.beans;

public class ErrorCodes {
	private ErrorCodes() {}
	public static final int SUCCESS_CODE = 0;
	public static final int NO_EMPLOYEE_LIST_CODE = 112;
	public static final int INVALID_REQUEST_ERROR_CODE = 113;
	public static final int INPUT_NOT_FOUND_CODE = 114;
	
	public static final String SUCCESS_MSG = "success";
	public static final String NO_EMPLOYEE_MSG = "no employee found";
	public static final String INVALID_REQUEST_ERROR_MSG = "invalid request";
	public static final String INPUT_NOT_FOUND_MSG = "Input not found";
}
