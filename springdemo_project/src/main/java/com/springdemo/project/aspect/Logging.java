package com.springdemo.project.aspect;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Aspect
@Component
public class Logging {
    private  static Logger logger=Logger.getLogger(Logging.class.getName());

    @Before("com.springdemo.project.aspect.Expressions.find()")
    public void beforeFinding()
    {
        logger.info("\n====> Finding from the service layer ");
    }
    @After("com.springdemo.project.aspect.Expressions.find()")
    public void afterFinding()
    {
        logger.info("\n====> Found from the service layer ");
    }
    @Before("com.springdemo.project.aspect.Expressions.save()")
    public void beforeSaving()
    {
        logger.info("\n====> Saving to the database  ");
    }
    @Before("com.springdemo.project.aspect.Expressions.delete()")
    public void beforeDelete()
    {
        logger.info("\n====> Deleting from the database  ");
    }
}
