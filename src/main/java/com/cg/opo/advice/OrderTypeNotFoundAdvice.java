package com.cg.opo.advice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.opo.exception.OrderTypeNotFoundException;

@ControllerAdvice
@RestController

public class OrderTypeNotFoundAdvice {
     @ExceptionHandler(OrderTypeNotFoundException.class)
      @ResponseStatus(HttpStatus.NOT_FOUND)
      String OrderTypeNotFoundHandler(OrderTypeNotFoundException ex) {
        return ex.getMessage();
     }
}