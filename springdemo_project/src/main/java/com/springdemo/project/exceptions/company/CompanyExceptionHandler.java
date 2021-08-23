package com.springdemo.project.exceptions.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CompanyExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CompanyErrorResponse> handleException(CompanyNotFoundException exception)
    {
        CompanyErrorResponse errorResponse=new CompanyErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CompanyErrorResponse> handleException(Exception exception)
    {
        CompanyErrorResponse errorResponse=new CompanyErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return  new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);

    }

}
