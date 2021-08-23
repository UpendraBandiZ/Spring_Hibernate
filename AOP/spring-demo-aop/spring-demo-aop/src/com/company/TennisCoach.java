package com.company;

import org.springframework.stereotype.Component;

@Component("myTennisCoach")
public class TennisCoach implements  Coach{
    @Override
    public String getDailyWorkOut() {
       return "tennis coach daily work out";
    }
}
