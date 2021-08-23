package com.springdemo.project.dao;

import com.springdemo.project.entity.City;
import com.springdemo.project.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
City findByCityName(String cityName);


}
