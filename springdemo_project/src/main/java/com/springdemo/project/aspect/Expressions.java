package com.springdemo.project.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Expressions {
    @Pointcut("execution(* com.springdemo.project.service.*.find*(..))")
    public void find()
    {

    }
    @Pointcut("execution(* com.springdemo.project.service.*.save*(..))")
    public void save()
    {

    }
    @Pointcut("execution(* com.springdemo.project.service.*.delete*(..))")
    public void delete()
    {

    }
}
