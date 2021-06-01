package com.cg.empmswithdb.controllers;

import com.cg.empmswithdb.exceptions.EmployeeNotFoundException;
import com.cg.empmswithdb.exceptions.InvalidEmployeeIdException;
import com.cg.empmswithdb.exceptions.InvalidEmployeeNameException;
import com.cg.empmswithdb.exceptions.InvalidSalaryException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * centralized exception handler
 */
@RestControllerAdvice
public class CentralizedExceptionHandler {

    /**
     *
     *
     * handles  EmployeeNotFoundException
     *
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFound(EmployeeNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidEmployeeIdException.class)
    public String handleInvalidId(InvalidEmployeeIdException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidEmployeeNameException.class)
    public String handleInvalidName(InvalidEmployeeNameException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidSalaryException.class)
    public String handleInvalidSalary(InvalidSalaryException e){
        return e.getMessage();
    }


}
