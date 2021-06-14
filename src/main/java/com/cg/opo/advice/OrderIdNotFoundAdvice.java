package com.cg.opo.advice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.opo.exception.OrderIdNotFoundException;


@ControllerAdvice
@RestController

public class OrderIdNotFoundAdvice {
     @ExceptionHandler(OrderIdNotFoundException.class)
      @ResponseStatus(HttpStatus.NOT_FOUND)
      String OrderIdNotFoundHandler(OrderIdNotFoundException ex) {
        return ex.getMessage();
     }
}