package com.testcase.labtestservice.exception;

public class LabTestIDAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4315034262933795032L;


	
	public String getMessage() {
		return " LabTest ID is already exists";
	}
}
