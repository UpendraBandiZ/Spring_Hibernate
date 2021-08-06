package com.company;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class BaseBallCoach  implements Coach {
    @Override
    public String getDailyWorkOut() {
        return " base ball";
    }
}
