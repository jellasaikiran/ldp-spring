package com.ldp.aopdemo.dao;

import com.ldp.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public List<Account> findAccounts(boolean b) {

        if(b){
            throw new RuntimeException("No soup for you!!");
        }
        List<Account> myAccounts = new ArrayList<>();

        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }
    public void addAccount(Account account, boolean flag){
        System.out.println(getClass()+" Doing my add account operation");
    }

    public void doWork(){
        System.out.println(getClass()+" doWork()");
    }

    public String getName() {
        System.out.println(getClass()+" getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+" setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+" getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+" setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
