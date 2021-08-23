package com.springdemo.project.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private int id;

    @NotNull
    @Size(min = 1,message = "is required")
    @Column(name = "city_name", nullable = false)
    private String cityName;

    @NotNull
    @Size(min = 1,message = "is required")
    @Column(name = "state_name", nullable = false)
    private String stateName;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="company_city",
            joinColumns = @JoinColumn(name="city_id"),
            inverseJoinColumns=@JoinColumn(name="company_id")
    )
    @ToString.Exclude
    private List<Company> companies;


    public City()
    {
    }

    public City(int id, String cityName, String stateName) {
        this.id = id;
        this.cityName = cityName;
        this.stateName = stateName;
    }

    public City(String cityName, String stateName) {
        this.cityName = cityName;
        this.stateName = stateName;
    }

    public void addCompany(Company company)
    {
        if(companies==null)
        {
            companies=new ArrayList<>();
        }
        companies.add(company);
    }

}
