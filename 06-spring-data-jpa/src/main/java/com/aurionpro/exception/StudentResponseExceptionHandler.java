package com.aurionpro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  //this will act as afirewall which will tell controller that it contains exceptions
public class StudentResponseExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(NoStudentRecordFoundException exc){
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.I_AM_A_TEAPOT.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.I_AM_A_TEAPOT);
	}
	
}
