package com.company;

public class CricketCoach implements  Coach{
    FortuneService fortuneService;
    private  String emailAddress;
    private String team;

    CricketCoach(){
        System.out.println("inside cricket coach constructor");
    }
    public void setEmailAddress(String emailAddress){
        System.out.println("setting email adress");
        this.emailAddress=emailAddress;
    }
    public void setTeam(String team){
        System.out.println("setting team name ");
        this.team=team;
    }

    public void setFortuneService(FortuneService fortuneService){
        System.out.println("cricket coach setter method");
        this.fortuneService=fortuneService;
    }
    @Override
    public String getDailyWorkOut() {
        return "cricket coach";
    }

    @Override
    public String getDailyFortune() {
        return  "crickrt coach"+fortuneService.getFortuneDetails();
    }
}
