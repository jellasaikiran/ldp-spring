package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach coach = context.getBean("tennisCoach",Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach",Coach.class);

        boolean result = (coach == alphaCoach);

        System.out.println(result);

        System.out.println("MemoryLocation of coach: "+ coach);
        System.out.println("MemoryLocation of aplha coach: "+ alphaCoach);
        context.close();
    }
}
