package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigSpringApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        SwimCoach myCoach = context.getBean("swimCoach", SwimCoach.class);
        System.out.println(myCoach.getDailyWorkout());
        System.out.println(myCoach.getDailyFortune());
        System.out.println("email: "+myCoach.getEmail());
        System.out.println("team: "+myCoach.getTeam());

        context.close();
    }
}
