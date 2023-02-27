package com.ldp.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {
    public String getFortune(){
        try{
            TimeUnit.SECONDS.sleep(5);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "Expect heavy traffic on the way..";
    }

    public String getFortune(boolean b){
        if(b){
            throw new RuntimeException("Major Accident! Highway is closed..");
        }
        return getFortune();
    }
}
