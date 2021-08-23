package com.luv2code.jackson.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        try {
            //create object manager
            ObjectMapper mapper=new ObjectMapper();


            //read json and map to java POJO
            Student student=mapper.readValue(new File("data/sample-full.json"),Student.class);


            System.out.println("FirstName:"+student.getFirstName());
            System.out.println("LastName:"+student.getLastName());
            Address address=student.getAddress();
            System.out.println("Address: "+address.getCity()+" "+address.getCountry());
            System.out.print("Languages: ");
            for(String tempLang:student.getLanguages()){
                System.out.println(tempLang);
            }


        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
