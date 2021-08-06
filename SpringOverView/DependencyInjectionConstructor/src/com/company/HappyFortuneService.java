package com.company;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortuneDetails() {
        return "Today is your lucky day";
    }
}
