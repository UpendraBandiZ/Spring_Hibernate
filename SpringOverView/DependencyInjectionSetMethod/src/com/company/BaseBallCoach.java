package com.company;

public class BaseBallCoach  implements Coach{
    private FortuneService fortuneService;
    private String emailAddress;
    private  String team;
    BaseBallCoach(){
        System.out.println("base ball coach constructor");
    }
    public void setEmailAddress(String emailAddress){
        System.out.println("setting email adress from properties file");
        this.emailAddress=emailAddress;
    }
    public void setTeam(String team){
        System.out.println("setting team name from properties ");
        this.team=team;
    }

    public void setFortuneService(FortuneService fortuneService){
        System.out.println("base ball coach setter method");
        this.fortuneService=fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return " base ball coach";
    }

    @Override
    public String getDailyFortune() {
        return "baseball"+fortuneService.getFortuneDetails();
    }
}
