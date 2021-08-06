package com.company;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;
    TrackCoach(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }
    @Override
    public String getDailyWorkOut() {
        return "track coach";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortuneDetails();
    }
}
