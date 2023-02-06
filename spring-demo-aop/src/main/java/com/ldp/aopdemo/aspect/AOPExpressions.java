package com.ldp.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

    @Pointcut("execution(* com.ldp.aopdemo.dao.*.*(..))")
    public void forDAOPackage(){}

    @Pointcut("execution(* com.ldp.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.ldp.aopdemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageNoGetterAndSetter(){}
}
