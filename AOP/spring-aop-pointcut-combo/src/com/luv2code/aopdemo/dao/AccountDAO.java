package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    private String name;
    private  String serviceCode;

    public void  addAccount(Account account,boolean vipFlag){
        System.out.println(getClass()+"Doing my db work adding an account");
    }

    public boolean doWork(){
        System.out.println(getClass()+"dowork method");
        return true;
    }

    public String getName() {
        System.out.println(getClass()+": in getname");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+":in set name");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": in get service code");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+":in set service code");
        this.serviceCode = serviceCode;
    }
}
