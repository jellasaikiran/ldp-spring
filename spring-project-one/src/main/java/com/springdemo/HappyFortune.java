package com.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortune implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is a lucky day";
    }
}
