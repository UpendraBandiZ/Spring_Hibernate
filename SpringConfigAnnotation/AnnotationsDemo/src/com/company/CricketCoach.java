package com.company;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements  Coach{
    @Override
    public String getDailyWorkOut() {
        return "cricket coach daily workout";
    }
}
