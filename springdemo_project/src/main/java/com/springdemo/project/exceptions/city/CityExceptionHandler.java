package com.springdemo.project.exceptions.city;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CityErrorResponse> handleException(CityNotFoundException exception)
    {
        CityErrorResponse errorResponse=new CityErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler
    public ResponseEntity<CityErrorResponse> handleException(Exception exception)
    {
        CityErrorResponse errorResponse=new CityErrorResponse();
        errorResponse.setTimestamp(System.currentTimeMillis());
        errorResponse.setMessage(exception.getMessage());
        return  new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
