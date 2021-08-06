package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements  Coach{
    FortuneService fortuneService;
    @Autowired
    @Qualifier("restFortuneService")
    public void setFortuneService(FortuneService fortuneService){
        System.out.println("setter method invoked ");
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
