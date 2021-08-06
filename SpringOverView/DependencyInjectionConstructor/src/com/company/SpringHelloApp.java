package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach coach=context.getBean("myBaseBallCoach",Coach.class);
        System.out.println(coach.getDailyWorkOut());
        System.out.println(coach.getDailyFortune());
        coach=context.getBean("myTrackCoach",Coach.class);
        System.out.println(coach.getDailyWorkOut());
        System.out.println(coach.getDailyFortune());
        context.close();
    }
}
