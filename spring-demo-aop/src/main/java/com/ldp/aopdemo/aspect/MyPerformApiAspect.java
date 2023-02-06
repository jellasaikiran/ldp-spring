package com.ldp.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyPerformApiAspect {
    @Before("com.ldp.aopdemo.aspect.AOPExpressions.forDAOPackageNoGetterAndSetter()")
    public void performApiAnalytics(){
        System.out.println("====>> Performing API Analytics");
    }

}
