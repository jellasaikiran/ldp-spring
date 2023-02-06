package com.ldp.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class MyLoginToCloudAspect {
    @Before("com.ldp.aopdemo.aspect.AOPExpressions.forDAOPackageNoGetterAndSetter()")
    public void loginToCloud(){
        System.out.println("====>> Logging in to cloud");
    }

}
