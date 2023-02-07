package com.ldp.aopdemo;

import com.ldp.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithExceptionalHandlingDemo {
    private static Logger logger = Logger.getLogger(AroundWithExceptionalHandlingDemo.class.getName());
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        logger.info("Main program started");
        String data = trafficFortuneService.getFortune(true);
        logger.info("Fortune: "+data);
        logger.info("Finished");
        context.close();
    }
}
