package com.luv2code.springdemo.mvc;

import com.luv2code.springdemo.mvc.validation.CourseCode;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class Customer {
    private String firstName;

    @NotNull(message ="is required")
    @Size(min = 1,message = "is required")
    private  String lastName;

     @NotNull(message = "is required")
     @Min(value = 0,message = "must be greater than or equal to zero")
     @Max(value = 10,message = "must be less than 10")
     private Integer freePasses;

     @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 digits")
     private String postalCode;

   @CourseCode(value = "zem",message = "must start with zem")
   private  String courseCode;


    public Customer(){

    }


    public Customer(String firstName, String lastName, Integer freePasses, String courseCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.freePasses = freePasses;
        this.courseCode = courseCode;
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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public void setCourseCode(String courseCode){
        this.courseCode=courseCode;
    }
    public String getCourseCode(){
        return this.courseCode;
    }

}
