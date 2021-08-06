package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements  Coach{
    FortuneService fortuneService;
    @Autowired
    public void methodForSettingFortuneService(FortuneService fortuneService){

        System.out.println("method setting fortuneService");
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return "tennis coach daily workout";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }
}
