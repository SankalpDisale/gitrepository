package com.cg.opo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.opo.exception.CoupanIdNotFoundException;

@RestControllerAdvice
public class InvalidCoupanOperationAdvice {
    
    @ExceptionHandler(CoupanIdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CoupanIdNotFoundHandler(CoupanIdNotFoundException ex) {
      return ex.getMessage();
    }

 

}