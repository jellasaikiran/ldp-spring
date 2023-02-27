package com.ldp.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.ldp.springdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.ldp.springdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.ldp.springdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {

        String theMethod = theJoinPoint.getSignature().toShortString();
        logger.info("=====>> in @Before: calling method: " + theMethod);

        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg : args) {
            logger.info("=====>> argument: " + tempArg);
        }
    }

    @AfterReturning(
            pointcut="forAppFlow()",
            returning="theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

        String theMethod = theJoinPoint.getSignature().toShortString();
        logger.info("=====>> in @AfterReturning: from method: " + theMethod);

        logger.info("=====>> result: " + theResult);

    }
}
