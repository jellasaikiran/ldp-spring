package com.ldp.aopdemo;

import com.ldp.aopdemo.dao.AccountDAO;
import com.ldp.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        System.out.println("Main program started");
        String data = trafficFortuneService.getFortune();
        System.out.println("Fortune: "+data);
        System.out.println("Finished");
        context.close();
    }
}
