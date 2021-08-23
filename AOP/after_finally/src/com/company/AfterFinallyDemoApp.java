package com.company;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
        List<Account> accounts=null;
        try {
            boolean tripWire=true;
            accounts= accountDAO.findAccounts(false);
        }
        catch (Exception exception){
            System.out.println("main program catch block"+exception);
        }

        System.out.println("\n main program after returning");
        System.out.println(accounts+"\n");
    }
}
