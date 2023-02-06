package com.ldp.aopdemo.dao;

import com.ldp.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean flag){
        System.out.println(getClass()+" Doing my add account operation");
    }

    public void doWork(){
        System.out.println(getClass()+" doWork()");
    }

}
