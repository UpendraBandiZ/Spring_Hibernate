package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach baseBallCoach1=context.getBean("myBaseBallCoach",Coach.class);
        Coach baseBallCoach2=context.getBean("myBaseBallCoach",Coach.class);
        //System.out.println(coach.getDailyWorkOut());
        System.out.println("baseballcoach1==baseeballcoach2"+(baseBallCoach1==baseBallCoach2));
        System.out.println("baseballcoach1 reference: " +baseBallCoach1);
        System.out.println("baseballcoach2 reference: " +baseBallCoach2);
      //  System.out.println(coach.getDailyWorkOut());
        Coach trackCoach1=context.getBean("myTrackCoach",Coach.class);
       Coach trackCoach2=context.getBean("myTrackCoach",Coach.class);
        System.out.println("trackCoach1==trackCoach2"+(trackCoach1==trackCoach2));
        System.out.println("trackcoach1 reference: " +trackCoach1);
        //System.out.println("trackCoach2 reference: "+trackCoach2);
        context.close();
    }
}
