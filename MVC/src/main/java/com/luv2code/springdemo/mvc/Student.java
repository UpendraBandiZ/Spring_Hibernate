package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String favourateLanguage;
    private String[] operatingSystems;

    public Student(String firstName, String lastName, String country, String favourateLanguage, String[] operatingSystem) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.favourateLanguage = favourateLanguage;

    }

    public Student() {


    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavourateLanguage() {
        return favourateLanguage;
    }

    public void setFavourateLanguage(String favourateLanguage) {
        this.favourateLanguage = favourateLanguage;
    }


    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}
