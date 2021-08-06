package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements  Coach{
    FortuneService fortuneService;
    @Autowired
    public CricketCoach(FortuneService fortuneService){
        this.fortuneService=fortuneService;

    }

    @Override
    public String getDailyWorkOut() {
        return "cricket coach daily workout";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }
}
