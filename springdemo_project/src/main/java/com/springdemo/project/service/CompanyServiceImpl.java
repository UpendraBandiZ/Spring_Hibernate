package com.springdemo.project.service;

import com.springdemo.project.dao.AuthoritiesRepository;
import com.springdemo.project.dao.CompanyRepository;
import com.springdemo.project.dao.UserRepository;
import com.springdemo.project.entity.Authorities;
import com.springdemo.project.entity.Company;
import com.springdemo.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(int theId) {
        //optional pattern instead of having to check for nulls
        Optional<Company> result=companyRepository.findById(theId);
        Company company=null;
        if(result.isPresent())
        {
            company=result.get();
        }
        else{
            throw new RuntimeException("no company exists with the given id");
        }
        return  company;
    }

    @Override
    public void save(Company company) {
        Company tempCompany=companyRepository.findByCompanyName(company.getCompanyName());
        if(tempCompany!=null)
        {
            throw new RuntimeException("company already registered");
        }



        String tempPassword="{noop}"+company.getPassword();
        User tempUser=new User(company.getCompanyName(),tempPassword,1);


            authoritiesRepository.save(new Authorities("ROLE_COMPANY", company.getCompanyName(), tempUser));

        //Company tempCompany=companyRepository.findByCompanyName(company.getCompanyName());

            companyRepository.save(company);;



    }

    @Override
    public void deleteById(int theId) {
        Optional<Company> result=companyRepository.findById(theId);
        Company tempCompany=null;
        if(result.isPresent())
        {
            tempCompany=result.get();
            User user=userRepository.findByUsername(tempCompany.getCompanyName());
            Authorities authorities=authoritiesRepository.findAllByUser(user);
            authoritiesRepository.delete(authorities);

        }

        companyRepository.deleteById(theId);

    }

    @Override
    public void updateCompany(Company company) {
        companyRepository.save(company);

    }


}
