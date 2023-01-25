package com.testcase.reportservice.exception;

public class ReportIdAlreadyExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9108385594055689561L;
	
	public String getMessage() {
		return "This Id is Already exixte in Report.";
	}

}
