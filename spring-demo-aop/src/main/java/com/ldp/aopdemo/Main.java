package com.ldp.aopdemo;

import com.ldp.aopdemo.dao.AccountDAO;
import com.ldp.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        Account account = new Account();
        account.setName("Madhu");
        account.setLevel("Platinum");
        accountDAO.addAccount(account, true);
        accountDAO.doWork();
        accountDAO.setName("foo");
        accountDAO.setServiceCode("silver");
        String name = accountDAO.getName();
        String serviceCode = accountDAO.getServiceCode();
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addSillyMethod();
        membershipDAO.goToSleep();
        context.close();
    }
}