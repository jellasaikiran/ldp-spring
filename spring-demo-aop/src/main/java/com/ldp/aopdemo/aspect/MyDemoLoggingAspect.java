package com.ldp.aopdemo.aspect;

import com.ldp.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.ldp.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortuneAdvice(
            ProceedingJoinPoint theJoinPoint) throws Throwable {

        String method = theJoinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @Around finally on method: " + method);
        long start = System.currentTimeMillis();
        Object o;
        try{
            o = theJoinPoint.proceed();
        }
        catch (Exception e){
            logger.warning(e.getMessage());
            throw e;
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        logger.info("Duration: "+duration);
        return o;

    }
    @AfterReturning(
            pointcut="execution(* com.ldp.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning="result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result) {

        String method = theJoinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @AfterReturning on method: " + method);
        convertAccountNamesToUpperCase(result);

        logger.info("\n=====>>> result is: " + result);

    }

    @AfterThrowing(
            pointcut="execution(* com.ldp.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing="exe")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable exe) {

        String method = theJoinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @AfterThrowing on method: " + method);

        logger.info("\n=====>>> Exception is: " + exe);

    }

    @After("execution(* com.ldp.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(
            JoinPoint theJoinPoint) {

        String method = theJoinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @After finally on method: " + method);

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
        logger.info("\n====>> Execution @Before advice on method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info(methodSignature.toString());

        for(Object arg: joinPoint.getArgs()){
            logger.info("arg: "+arg);
            if(arg instanceof Account){
                logger.info("Account Details\t name: "+((Account) arg).getName()+"\tlevel: "+((Account) arg).getLevel());
            }
        }
    }

}
