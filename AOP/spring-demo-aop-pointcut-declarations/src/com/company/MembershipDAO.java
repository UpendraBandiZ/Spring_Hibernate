package com.company;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {


    public boolean  addAccount(){
        System.out.println(getClass()+"membership dao add account method");
        return true;
    }
   public void goToSleep(){
       System.out.println(getClass()+" go to sleep method");
   }
}
