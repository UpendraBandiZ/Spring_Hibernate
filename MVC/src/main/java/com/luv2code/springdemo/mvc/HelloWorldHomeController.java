package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
@RequestMapping("/hello")
@Controller
public class HelloWorldHomeController {
    @RequestMapping("/showForm")
    public String showForm(){
        return "hello-world-form";
    }
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model)
    {
        String theName=request.getParameter("studentName");
        theName=theName.toUpperCase();
        String  result="Yo"+theName;
        model.addAttribute("message",result);

        return "helloworld";
    }
    @RequestMapping("/processFormVersionThree")
    public String letsShoutDudethree(@RequestParam("studentName") String theName, Model model)
    {
        //String theName=request.getParameter("studentName");
        theName=theName.toUpperCase();
        String  result="Hey my friend v3"+theName;
        model.addAttribute("message",result);

        return "helloworld";
    }
}
