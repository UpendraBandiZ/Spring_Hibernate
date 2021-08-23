package com.springdemo.project.controller;

import com.springdemo.project.entity.City;
import com.springdemo.project.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CityService cityService;



    @GetMapping("/cityList")
    public String printList(Model model)
    {
        List<City>  cityList=cityService.findAll();
        model.addAttribute("cityList",cityList);
        return "all_cities_list";
    }

    @PostMapping("/showFormForUpdate")
    public String add(@RequestParam("cityId") int cityId, Model model)
    {
       City city=cityService.findById(cityId);
       model.addAttribute("city",city);
//        System.out.println("heyyefwef");

        return "admin_city_form";
    }
    @PostMapping("/updateCity")
    public String saveCity( @ModelAttribute("city") City city)


    {
//        System.out.println("saving city in admin controller");
        City tempCity=cityService.findById(city.getId());
        if(tempCity!=null) {
            tempCity.setCityName(city.getCityName());
            tempCity.setStateName(city.getStateName());
            cityService.updateCity(tempCity);
        }

//        System.out.println("saving done");
            return "redirect:/admin/cityList";

    }


}
