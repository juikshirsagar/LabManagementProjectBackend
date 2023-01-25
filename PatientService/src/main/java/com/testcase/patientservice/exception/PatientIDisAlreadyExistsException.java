package com.testcase.patientservice.exception;

public class PatientIDisAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -137762280145812987L;
	
	public String getMessager() {
		return "Patient ID is Already Exists.";
	}

}
