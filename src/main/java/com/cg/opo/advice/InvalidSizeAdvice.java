package com.cg.opo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.opo.exception.InvalidSizeException;

@ControllerAdvice
@RestController

public class InvalidSizeAdvice {
     @ExceptionHandler(InvalidSizeException.class)
      @ResponseStatus(HttpStatus.NOT_FOUND)
      String InvalidMinCostHandler(InvalidSizeException ex) {
        return ex.getMessage();
      }


    }
