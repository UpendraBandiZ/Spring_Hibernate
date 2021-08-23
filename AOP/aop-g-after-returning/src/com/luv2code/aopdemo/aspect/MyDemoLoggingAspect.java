package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result)
    {
        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n====>executing @After returning"+method);
        System.out.println("result is"+result);
        //modifying
        Account account=result.get(0);
        account.setName("Harry potter");
        System.out.println("after modifying in @after "+result);

    }






    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackNoGetterSetter()")
    public void  beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("\n ======>>> executing @Before advice on add Account");


        //display method signature
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        System.out.println("method:"+methodSignature);


        //display method arguemnets

        Object[] args=joinPoint.getArgs();
        for(Object temp:args){
            System.out.println(temp);
            if(temp instanceof Account) {
                Account account = (Account) temp;
                System.out.println(account.getLevel());
                System.out.println(account.getName());
            }
        }

    }


}
