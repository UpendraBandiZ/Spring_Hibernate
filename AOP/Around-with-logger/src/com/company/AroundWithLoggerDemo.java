package com.company;

import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemo {
    private static Logger logger=Logger.getLogger(AroundWithLoggerDemo.class.getName());


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
        logger.info("main program calling fortune");
        String data=trafficFortuneService.getFortune();
        logger.info("my fortune is "+data);
        logger.info("finished");


        context.close();
    }
}
