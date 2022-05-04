package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandler {

	
	@org.springframework.web.bind.annotation.ExceptionHandler(ApiException.class)
	public ResponseEntity<String> handleApiException (
			ApiException ex,WebRequest web
			){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	}
