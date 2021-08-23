package com.springdemo.project.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    @NotNull
    private int id;

    @NotNull
    @Size(min = 1,message = "is required")
    @Column(name = "company_name",nullable = false)
    private String companyName;

    @NotNull
    @Size(min = 1,max = 5)
    @Column(name = "cmmi_level",nullable = false)
    private int cmmiLevel;

    @NotNull
    @Size(min = 10)
    @Column(name = "head_count", nullable = false)
    private int headCount;

    @NotNull
    @Size(min =1,message = "is required")
    @Column(name = "password",nullable = false)
    private String password;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="company_city",
            joinColumns = @JoinColumn(name="company_id"),
            inverseJoinColumns=@JoinColumn(name="city_id")
    )
    @ToString.Exclude
    private List<City> cities;

    public Company()
    {

    }

    public Company(int id, String companyName, int cmmiLevel, int headCount) {
        this.id = id;
        this.companyName = companyName;
        this.cmmiLevel = cmmiLevel;
        this.headCount = headCount;
    }

    public Company(String companyName, int cmmiLevel, int headCount) {
        this.companyName = companyName;
        this.cmmiLevel = cmmiLevel;
        this.headCount = headCount;
    }

    public void addCity(City city)
    {
        if(cities==null)
        {
            cities=new ArrayList<>();
        }
        cities.add(city);
    }
}
