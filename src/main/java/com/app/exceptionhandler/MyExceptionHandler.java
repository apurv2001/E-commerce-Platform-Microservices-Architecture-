package com.app.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.customexception.ProductEntityFoundException;
import com.app.customexception.InSufficientEntityFoundException;
import com.app.customexception.NoProductEntityFoundException;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(NoProductEntityFoundException.class)
	public ResponseEntity<String> noBookEntityException(NoProductEntityFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductEntityFoundException.class)
	public ResponseEntity<String> bookEntityException(ProductEntityFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InSufficientEntityFoundException.class)
	public ResponseEntity<String> inSufficientEntityException(InSufficientEntityFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

}
