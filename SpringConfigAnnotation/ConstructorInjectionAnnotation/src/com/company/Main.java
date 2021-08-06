package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach coach=context.getBean("cricketCoach",Coach.class);
        System.out.println(coach.getDailyWorkOut());
        System.out.println(coach.getDailyFortune());
        context.close();

    }
}
