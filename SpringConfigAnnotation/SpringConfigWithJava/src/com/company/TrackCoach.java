package com.company;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;
    @Value("${f.email}")
    private  String email;
    @Value("${name}")
    private String name;
    public TrackCoach(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return "track coach";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
