package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements  Coach{
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;
    @Override
    public String getDailyWorkOut() {
        return "foot ball coach";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }
}
