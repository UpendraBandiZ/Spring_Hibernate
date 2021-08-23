package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Before("forDaoPackage()")
    //    @Before("execution(public * add*(com.luv2code.aopdemo.Account))")
    public void  beforeAddAccountAdvice(){
        System.out.println("\n ======>>> executing @Before advice on add Account");

    }
    @Before("forDaoPackage()")
    public void performAnalytics(){
        System.out.println("\n=====>>>> performing API analytics");
    }

}
