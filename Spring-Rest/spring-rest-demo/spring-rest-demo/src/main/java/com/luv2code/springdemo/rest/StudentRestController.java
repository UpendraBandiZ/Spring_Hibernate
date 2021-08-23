package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;


    //define postconstruct to load student data ..only once

    @PostConstruct
    public void loadData(){
      theStudents=new ArrayList<>();
        theStudents.add(new Student("sanath","kumar"));
        theStudents.add(new Student("dhanraj","poorika"));
        theStudents.add(new Student("teja","sai"));
        theStudents.add(new Student("rohith","sai"));

    }
    @GetMapping("/students")
    public List<Student> getStudents(){


        return theStudents;
    }
    //define end point for "/students/{studentid}" return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if(studentId>=theStudents.size() || (studentId<0)){
            throw new StudentNotFoundException("student id not found "+studentId);
        }


        return  theStudents.get(studentId);
    }

    //add exception handler using @Exception Handler


    //add another exception handler ..to catch any exception

}
