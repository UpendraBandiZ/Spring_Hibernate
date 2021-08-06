package com.company;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class BaseBallCoach  implements Coach {
    @Override
    public String getDailyWorkOut() {
        return " base ball daily workout";
    }
    @PostConstruct
    public void initMethod(){
        System.out.println("base ball coach init methhod");
    }
    @PreDestroy
    public  void destroyMethod(){
        System.out.println("base ball destory method");
    }

}
