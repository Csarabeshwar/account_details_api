package com.anz.account.details.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.anz.account.details.model.ApiError;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler({})
	public ResponseEntity<ApiError> handleGeneralException(Exception exception, HttpServletRequest request){
		return new ResponseEntity<ApiError>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({AccountNotFoundException.class})
	public ResponseEntity<ApiError> accountNotFoundException(Exception exception, HttpServletRequest request){
		return new ResponseEntity(exception.getMessage(), HttpStatus.NO_CONTENT);
	}
	
}
