package com.company;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TrackCoach implements  Coach{
    @Override
    public String getDailyWorkOut() {
        return "track coach";
    }
}
