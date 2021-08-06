package com.company;

import org.springframework.stereotype.Component;

public class BaseBallCoach  implements Coach {
    private FortuneService fortuneService;
    public  BaseBallCoach(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return " base ball";
    }

    @Override
    public String getFortune() {
        return  fortuneService.getFortune();
    }


}
