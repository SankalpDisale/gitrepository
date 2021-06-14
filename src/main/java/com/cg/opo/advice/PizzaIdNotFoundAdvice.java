package com.cg.opo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.opo.exception.PizzaIdNotFoundException;

@RestControllerAdvice
public class PizzaIdNotFoundAdvice {

    @ExceptionHandler(PizzaIdNotFoundException.class)
      @ResponseStatus(HttpStatus.NOT_FOUND)
      String PizzaIdNotFoundHandler(PizzaIdNotFoundException ex) {
        return ex.getMessage();
      }
 
}