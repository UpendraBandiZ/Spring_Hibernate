package com.springdemo.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public String sayHello() {
        return "welcome";
    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login-page";
    }

  @GetMapping("/access-denied")
    public String accessDenied()
  {
      return "access-denied";
  }



}