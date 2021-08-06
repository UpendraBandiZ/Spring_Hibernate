package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        // explicit bean
        Coach coach=context.getBean("myTennisCoach",Coach.class);
        System.out.println(coach.getDailyWorkOut());
        // default bean
         coach=context.getBean("cricketCoach",Coach.class);
        System.out.println(coach.getDailyWorkOut());
    }
}
