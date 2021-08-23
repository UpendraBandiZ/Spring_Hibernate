package com.springdemo.project.convertor;

import com.springdemo.project.dto.CompanyDTO;
import com.springdemo.project.entity.Company;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyConvertor {

    public CompanyDTO entityToDto(Company company)
    {
        ModelMapper mapper=new ModelMapper();
        CompanyDTO map=mapper.map(company,CompanyDTO.class);
        return map;
    }
    public Company dtoToEntity(CompanyDTO companyDTO)
    {
        ModelMapper mapper=new ModelMapper();
        Company map=mapper.map(companyDTO,Company.class);
        return map;
    }
    public List<CompanyDTO> entityToDto(List<Company> companies)
    {
        return  companies.stream().map(x->entityToDto(x)).collect(Collectors.toList());

    }
    public List<Company> dtoToEntity(List<CompanyDTO> companyDTOList){

        return companyDTOList.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
