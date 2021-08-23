package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.jar.JarEntry;
import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    //set up logger
    private Logger logger=Logger.getLogger(getClass().getName());
    @Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
    private void forControllerPackage(){

    }
    @Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
    private void forServicelerPackage(){

    }
    @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
    private void forDaoPackage(){

    }

    @Pointcut("forControllerPackage() || forServicelerPackage() || forDaoPackage()")
    private void forAppFlow(){};


  @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
      String method=joinPoint.getSignature().toShortString();
      logger.info("=====>>@Before calling method"+method);

      Object[] args=joinPoint.getArgs();
      for(Object temp:args)
          logger.info("==>>argument"+temp);
  }


  @AfterReturning(
          pointcut = "forAppFlow()",
          returning="result"
  )
    public  void afterReturning(JoinPoint joinPoint,Object result){
      String method=joinPoint.getSignature().toShortString();
      logger.info("@after returning"+method);

  }
}
