package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach coach=context.getBean("cricketCoach",Coach.class);
        System.out.println(coach.getDailyFortune());
        coach=context.getBean("tennisCoach",Coach.class);
        System.out.println(coach.getDailyFortune());
        coach=context.getBean("footBallCoach",Coach.class);
        System.out.println(coach.getDailyFortune());

        context.close();
    }
}
