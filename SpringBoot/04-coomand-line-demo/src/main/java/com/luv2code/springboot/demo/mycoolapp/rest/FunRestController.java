package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.util.resources.LocaleData;

import java.time.LocalDateTime;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello World time on server is "+ LocalDateTime.now();
    }
    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "run a hard 5k ok";
    }
    @GetMapping("/fortune")
    public String getdailyFortune(){
        return "this is lucky day go ahead man ";
    }

}
