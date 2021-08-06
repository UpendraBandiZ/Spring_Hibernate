package com.company;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportsConfig.class);
        Coach baseBallCoach1=context.getBean("baseBallCoach", Coach.class);
        System.out.println(baseBallCoach1.getDailyWorkOut());
        System.out.println(baseBallCoach1.getFortune());
        TrackCoach trackCoach1=context.getBean("trackCoach", TrackCoach.class);
        System.out.println(trackCoach1.getDailyWorkOut());
        System.out.println(trackCoach1.getFortune());
        System.out.println(trackCoach1.getEmail());
        System.out.println(trackCoach1.getName());
        context.close();
    }
}
