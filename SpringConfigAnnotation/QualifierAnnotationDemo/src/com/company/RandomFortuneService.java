package com.company;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class RandomFortuneService implements FortuneService{
    private String[] data={"RanndomFortuneService1","RanndomFortuneService2","RanndomFortuneService3"};
    @Override
    public String getDailyFortune() {
        Random random=new Random();
        int index=random.nextInt(data.length);
        return data[index];
    }
}
