package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;
    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String team;

    @Autowired

    public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside default contstructor");
        this.fortuneService = fortuneService;

    }

    @Override
    public String getDailyWorkout() {
        System.out.println(email);
        System.out.println(team);
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

//    @Autowired
//    public void doSomeCrazyStuff(FortuneService fortuneService) {
//
//        System.out.println(">> TennisCoach: inside doSomeCrazyStuff");
//        this.fortuneService = fortuneService;
//    }





}
