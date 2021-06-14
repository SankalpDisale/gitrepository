package com.cg.opo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.opo.exception.CustomerIdNotFoundException;

@RestControllerAdvice
public class CustomerIdNotFoundAdvice {

	@ExceptionHandler(CustomerIdNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String CustomerIdNotFoundHandler(CustomerIdNotFoundException ex) {
		return ex.getMessage();
	}
	
}
