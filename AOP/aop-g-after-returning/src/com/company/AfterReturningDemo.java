package com.company;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
        List<Account> accounts=accountDAO.findAccounts();
        System.out.println("\n main program after returning");
        System.out.println(accounts+"\n");
    }
}
