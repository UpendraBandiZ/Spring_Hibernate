package com.company;

import com.oracle.webservices.internal.api.message.PropertySet;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")

public class SportsConfig {
    @Bean
    public FortuneService happyFortuneService(){
        return new HappyFortuneService();
    }
    @Bean
    public Coach baseBallCoach(){
        return  new BaseBallCoach(happyFortuneService());
    }
    @Bean
    public Coach trackCoach(){
        return  new TrackCoach(happyFortuneService());
    }


}
