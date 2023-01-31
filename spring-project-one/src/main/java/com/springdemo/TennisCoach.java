package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("happyFortune")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("Tennis Coach constructor");
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
