package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("happyFortune")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("Tennis Coach constructor");
    }

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("Tennis coach initialised");
    }

    @PreDestroy
    public void doMyCleanupStuffYoYo(){
        System.out.println("Tennis coach destroyed");
    }

//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println("Setting fortune service");
//        this.fortuneService = fortuneService;
//    }
//
//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        System.out.println("Tennis coach constructor with one parameter");
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
