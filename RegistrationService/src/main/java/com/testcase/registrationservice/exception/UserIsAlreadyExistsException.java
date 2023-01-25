package com.testcase.registrationservice.exception;

import org.springframework.security.core.AuthenticationException;

public class UserIsAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 928690310644555020L;

	public String getMessage() {
		return  "User is Already Exist";
	}
}
