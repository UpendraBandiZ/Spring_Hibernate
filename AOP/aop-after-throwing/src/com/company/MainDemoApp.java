package com.company;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainDemoApp {

    public static void main(String[] args) {
	// write your code here
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
        Account account=new Account();
        account.setLevel("platinum");
        account.setName("madhu");
        accountDAO.addAccount(account,true);
        accountDAO.doWork();
        //calling getter and setter
        accountDAO.setServiceCode("silver");
        accountDAO.setName("foobar");
        String name=accountDAO.getName();
        String code=accountDAO.getServiceCode();

        MembershipDAO membershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
        membershipDAO.addAccount();
        membershipDAO.goToSleep();


        context.close();

    }
}
