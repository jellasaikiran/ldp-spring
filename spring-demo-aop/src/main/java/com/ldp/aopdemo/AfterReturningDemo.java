package com.ldp.aopdemo;

import com.ldp.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterReturningDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        Account account = new Account();
        account.setName("Madhu");
        account.setLevel("Platinum");
        accountDAO.findAccounts(false);
    }
}
