package com.springdemo.project.exceptions.company;

import lombok.Data;
@Data
public class CompanyErrorResponse {
    private String message;
    private  long timestamp;
    public CompanyErrorResponse()
    {

    }
    public CompanyErrorResponse(String message, long timestamp)
    {
        this.message=message;
        this.timestamp=timestamp;
    }
}
