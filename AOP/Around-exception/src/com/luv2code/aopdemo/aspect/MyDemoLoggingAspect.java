package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
    private Logger logger=Logger.getLogger(getClass().getName());
    
    

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public  Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        String method=proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n====>executing @Around returning"+method);
        Long begin=System.currentTimeMillis();
        //exceuting actual target method
        Object result=null;
        try {
            result = proceedingJoinPoint.proceed();
        }
        catch (Exception e) {
            logger.warning(e.getMessage());
           // throw e;
        }

        long end=System.currentTimeMillis();
        long duration=end-begin;
        logger.info("====>duration"+duration/1000.0+"seconds");


        return  result;
    }





    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccounts(JoinPoint joinPoint)
    {
        String method=joinPoint.getSignature().toShortString();
        logger.info("\n====>executing @After(FINALY) returning"+method);

    }




    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result)
    {
        String method=joinPoint.getSignature().toShortString();
        logger.info("\n====>executing @After returning"+method);
        logger.info("result is"+result);
        //modifying
        Account account=result.get(0);
        account.setName("Harry potter");
        logger.info("after modifying in @after "+result);

    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterthrowingException(JoinPoint joinPoint,Throwable theExc){

        logger.info("=====.>> @after thrwoing "+theExc);
    }





    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackNoGetterSetter()")
    public void  beforeAddAccountAdvice(JoinPoint joinPoint){
        logger.info("\n ======>>> executing @Before advice on add Account");


        //display method signature
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        logger.info("method:"+methodSignature);


        //display method arguemnets

        Object[] args=joinPoint.getArgs();
        for(Object temp:args){
            logger.info(temp.toString());
            if(temp instanceof Account) {
                Account account = (Account) temp;
                logger.info(account.getLevel());
                logger.info(account.getName());
            }
        }

    }


}
