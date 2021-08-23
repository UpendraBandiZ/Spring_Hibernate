package com.springdemo.project.dto;

import com.springdemo.project.entity.City;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CompanyDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @NotNull
    @Size(min = 1,message = "is required")
    private String companyName;

    @NotNull
    @Size(min = 1,max = 5)
    private int cmmiLevel;

    @NotNull
    @Size(min = 10)
    private int headCount;

    @NotNull
    @Size(min =1,message = "is required")
    private String password;


    @ToString.Exclude
    private List<City> cities;

}
