package com.springdemo;

public class HappyFortune implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is a lucky day";
    }
}
