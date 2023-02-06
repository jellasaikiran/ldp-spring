package com.ldp.aopdemo.aspect;

import com.ldp.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

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
