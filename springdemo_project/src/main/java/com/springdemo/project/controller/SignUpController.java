package com.springdemo.project.controller;

import com.springdemo.project.convertor.CompanyConvertor;
import com.springdemo.project.dto.CompanyDTO;
import com.springdemo.project.entity.Company;
import com.springdemo.project.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class SignUpController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/signUp")
    public String singUp(Model model) {
        model.addAttribute("company",new Company());
        return "signup_form";
    }

    @PostMapping("/register")
    public String saveCompany(@ModelAttribute("company") CompanyDTO companyDTO) {
        Company company=new CompanyConvertor().dtoToEntity(companyDTO);

        companyService.save(company);
        return "login-page";
    }


}
