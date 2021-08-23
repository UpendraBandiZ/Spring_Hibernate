package com.springdemo.project.controller;

import com.springdemo.project.convertor.CompanyConvertor;
import com.springdemo.project.dto.CompanyDTO;
import com.springdemo.project.entity.Company;
import com.springdemo.project.service.CompanyService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

     @GetMapping("/list")
    public String listCompany(Model model)
     {
         CompanyConvertor companyConvertor=new CompanyConvertor();
          List<CompanyDTO> companyDTOList=companyConvertor.entityToDto(companyService.findAll());
         //List<Company> companies=companyService.findAll();

//         model.addAttribute("companies",companies);
         model.addAttribute("companies",companyDTOList);
         return "company_list";
     }


    @PostMapping("/showFormForUpdateCompany")
    public String showFormForUpdate(@RequestParam("companyId") int theId,Model model)
    {
         CompanyDTO companyDTO=new CompanyConvertor().entityToDto(companyService.findById(theId));
//        Company company=companyService.findById(theId);
        model.addAttribute("company",companyDTO);

        return "company_form";
    }
    @PostMapping("/updateCompany")
    public String updateCompany( @ModelAttribute("company") CompanyDTO companyDTO)
    {
        Company company=new CompanyConvertor().dtoToEntity(companyDTO);
        Company tempCompany=(companyService.findById(company.getId()));
        if(tempCompany!=null)
        {
//                Company company1= result.get();
            tempCompany.setCmmiLevel(company.getCmmiLevel());
            tempCompany.setHeadCount(company.getHeadCount());
            companyService.updateCompany(tempCompany);
        }

        return "redirect:/company/list";
    }

    @PostMapping("/deleteCompany")
    public String deleteById(@RequestParam("companyId") int theId)
    {

        companyService.deleteById(theId);
        return "redirect:/company/list";
    }





}
