package com.ldp.aopdemo.aspect;

import com.ldp.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
    @AfterReturning(
            pointcut="execution(* com.ldp.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning="result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result) {

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====>>> result is: " + result);

    }

    @AfterThrowing(
            pointcut="execution(* com.ldp.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing="exe")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable exe) {

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        System.out.println("\n=====>>> Exception is: " + exe);

    }

    @After("execution(* com.ldp.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(
            JoinPoint theJoinPoint) {

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After finally on method: " + method);

    }
    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts

        for (Account tempAccount : result) {

            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);
        }

    }

    @Before("com.ldp.aopdemo.aspect.AOPExpressions.forDAOPackageNoGetterAndSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("\n====>> Execution @Before advice on method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println(methodSignature);

        for(Object arg: joinPoint.getArgs()){
            System.out.println("arg: "+arg);
            if(arg instanceof Account){
                System.out.println("Account Details\t name: "+((Account) arg).getName()+"\tlevel: "+((Account) arg).getLevel());
            }
        }
    }

}
