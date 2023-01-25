package com.testcase.registrationservice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	 @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    @ExceptionHandler(UserIsAlreadyExistsException.class)
	    public Map<String, String> handleBusinessException(UserIsAlreadyExistsException ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", ex.getMessage());
	        return errorMap;
	    }
}
