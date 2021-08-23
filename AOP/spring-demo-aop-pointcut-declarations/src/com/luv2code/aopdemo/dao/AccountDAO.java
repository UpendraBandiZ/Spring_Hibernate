package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void  addAccount(Account account, boolean vipFlag){
        System.out.println(getClass()+"Doing my db work adding an account");
    }

    public boolean doWork(){
        System.out.println(getClass()+"do work method");
        return true;
    }
}
