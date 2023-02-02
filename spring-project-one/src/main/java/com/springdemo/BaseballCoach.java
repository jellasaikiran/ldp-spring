package com.springdemo;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        System.out.println("Invoked constructor");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Spend 30 mins for batting practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void doMyStartupStuff(){
        System.out.println("BaseballCoach initialised");
    }
    public void doMyCleanupStuffYoYo(){
        System.out.println("BaseballCoach destroyed");
    }
}
