package com.springdemo.project.service;

import com.springdemo.project.entity.Company;

import java.util.List;

public interface CompanyService {
    public List<Company> findAll();
    public Company findById(int theId);
    public void save(Company company);
    public void deleteById(int theId);
    public void updateCompany(Company company);
}
