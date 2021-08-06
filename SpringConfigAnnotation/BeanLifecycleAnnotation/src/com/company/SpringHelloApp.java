package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach baseBallCoach1=context.getBean("baseBallCoach", Coach.class);
        System.out.println(baseBallCoach1.getDailyWorkOut());

        context.close();
    }
}
