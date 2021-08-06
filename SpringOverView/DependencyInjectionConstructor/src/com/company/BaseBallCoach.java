package com.company;

public class BaseBallCoach  implements Coach {
    private FortuneService fortuneService;
    BaseBallCoach(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return " base ball";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortuneDetails();
    }
}
