package com.company;
public class TrackCoach implements Coach {
    private FortuneService fortuneService;
    TrackCoach(){
        System.out.println("track coach constructor");
    }
    public void setFortuneService(FortuneService fortuneService){
        System.out.println("track coach setter method");
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return "track coach";
    }

    @Override
    public String getDailyFortune() {
        return "Track coach"+fortuneService.getFortuneDetails();
    }
}
