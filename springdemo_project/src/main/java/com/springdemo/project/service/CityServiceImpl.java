package com.springdemo.project.service;

import com.springdemo.project.dao.CityRepository;
import com.springdemo.project.dao.CompanyRepository;
import com.springdemo.project.entity.City;
import com.springdemo.project.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements  CityService{

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }


    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public String getCurrentCompanyName()
    {
        String  currentCompanyName=null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentCompanyName = authentication.getName();
        }

        return  currentCompanyName;
    }

    @Override
    public City findById(int theId) {
        Optional<City> result=cityRepository.findById(theId);
        City city=null;
        if(result.isPresent())
        {
            city=result.get();
        }
        else {
            throw new RuntimeException("city not found with the given id");

        }
        return city;
    }

    @Override
    public void save(City city) {
        Company company=companyRepository.findByCompanyName(getCurrentCompanyName());


        List<City> tempCities=company.getCities();
        for(City temp:tempCities)
        {
            if(temp.getCityName().equals(city.getCityName()))
                return;

        }

           City tempCity=cityRepository.findByCityName(city.getCityName());
           if(tempCity==null) {

               company.addCity(city);
               cityRepository.save(city);
           }

           else
           {
               tempCity.addCompany(company);
               cityRepository.save(tempCity);
           }

    }

    @Override
    public void deleteById(int theId) {
        Company tempCompany=companyRepository.findByCompanyName(getCurrentCompanyName());
        List<City> newCities=new ArrayList<>();
        List<City> cities=tempCompany.getCities();
        for(City temp:cities)
        {
            if(temp.getId()!=theId)
            {
                newCities.add(temp);
            }
        }
        tempCompany.setCities(newCities);
//        System.out.println("delete check"+tempCompany.getCities());
        companyRepository.save(tempCompany);

       // cityRepository.deleteById(theId);

    }

    @Override
    public List<City> findAllByCompany() {
        Company company=companyRepository.findByCompanyName(getCurrentCompanyName());
        return company.getCities();
    }

    @Override
    public void updateCity(City city) {
       cityRepository.save(city);
    }


}
