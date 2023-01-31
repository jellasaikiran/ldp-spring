package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationSpringApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach myCoach = context.getBean("tennisCoach", TennisCoach.class);
        System.out.println(myCoach.getDailyWorkout());
        context.close();
    }
}
