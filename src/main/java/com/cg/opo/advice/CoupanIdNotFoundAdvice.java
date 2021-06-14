package com.cg.opo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.cg.opo.exception.CoupanIdNotFoundException;

@ControllerAdvice
@RestController
public class CoupanIdNotFoundAdvice {
    
    @ExceptionHandler(CoupanIdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CoupanIdNotFoundHandler(CoupanIdNotFoundException ex) {
      return ex.getMessage();
    }

}