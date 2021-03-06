package com.cg.opo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.cg.opo.exception.InvalidMinCostException;
@ControllerAdvice
@RestController

public class InvalidMinCostAdvice {
     @ExceptionHandler(InvalidMinCostException.class)
      @ResponseStatus(HttpStatus.NOT_FOUND)
      String InvalidMinCostHandler(InvalidMinCostException ex) {
        return ex.getMessage();
      }


    }
