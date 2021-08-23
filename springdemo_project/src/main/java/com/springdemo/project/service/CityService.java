package com.springdemo.project.service;

import com.springdemo.project.entity.City;
import java.util.List;

public interface CityService {
    public List<City> findAll();
    public City findById(int theId);
    public void save(City city);
    public void deleteById(int theId);


    List<City> findAllByCompany();
    public void updateCity(City city);
}
