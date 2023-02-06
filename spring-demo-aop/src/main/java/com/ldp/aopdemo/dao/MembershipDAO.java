package com.ldp.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public String addSillyMethod(){
        System.out.println(getClass()+" Doing my add account operation in membership dao.");
        return "MembershipDAO add";
    }

    public void goToSleep(){
        System.out.println(getClass()+" going to sleep");
    }

}
