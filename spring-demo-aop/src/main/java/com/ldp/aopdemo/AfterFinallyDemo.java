package com.ldp.aopdemo;

import com.ldp.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = null;
        try{
            accounts = accountDAO.findAccounts(false);
        }
        catch (Exception e){
            System.out.println("Main program exception "+e);
        }

    }
}
