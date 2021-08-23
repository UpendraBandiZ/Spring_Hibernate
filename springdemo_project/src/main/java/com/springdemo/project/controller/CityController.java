package com.springdemo.project.controller;


import com.springdemo.project.entity.City;
import com.springdemo.project.entity.Company;
import com.springdemo.project.service.CityService;
import com.springdemo.project.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private CompanyService companyService;

    @GetMapping("/list")
    public String listCities(Model model)
    {
        List<City> cities=cityService.findAllByCompany();
        model.addAttribute("cities",cities);
        return "city_list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        City  city=new City();
        city.setId(0);
        model.addAttribute("city",city);
        return "city_form";
    }
    @PostMapping("/save")
    public String saveCity(@Valid @ModelAttribute("city") City city, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "city_form";
        }
        cityService.save(city);
        return "redirect:/city/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("cityId") int theId)
    {
        cityService.deleteById(theId);
        return "redirect:/city/list";
    }
}
