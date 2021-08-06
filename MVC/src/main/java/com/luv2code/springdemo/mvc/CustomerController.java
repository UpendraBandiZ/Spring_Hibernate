package com.luv2code.springdemo.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    //add an initbinder
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        //below api true means string to null
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    @RequestMapping("/showForm")
    public String showForm(Model theModel){
        theModel.addAttribute("customer",new Customer());
       return "customer-form";
    }
    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult theBindingResult){
        System.out.println(theBindingResult.hasErrors());
        System.out.println(theBindingResult+"\n\n");
        if(theBindingResult.hasErrors()) {

            return "customer-form";
        }
        else {
            return "customer-confirmation";
        }
    }


}
