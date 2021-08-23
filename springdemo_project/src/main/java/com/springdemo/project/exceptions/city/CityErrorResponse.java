package com.springdemo.project.exceptions.city;

import lombok.Data;

@Data
public class CityErrorResponse {
    private String message;
    private long timestamp;
    public CityErrorResponse()
    {

    }
    public CityErrorResponse(String message,long timestamp)
    {
        this.message=message;
        this.timestamp=timestamp;
    }
}
