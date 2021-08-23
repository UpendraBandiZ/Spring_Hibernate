package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController  {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    @GetMapping("/employee")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee employee=employeeService.findById(employeeId);
        if(employee==null){
            throw new RuntimeException("employee id not found"+employeeId);

        }
        return employee;
    }


    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee )
    {
       employeeService.save(employee);
       return employee;
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    { Employee employee=employeeService.findById(employeeId);
        if(employee==null){
            throw new RuntimeException("this employee not exist in database");
        }
        employeeService.deleteById(employeeId);
        return "deleted employee id"+employeeId;

    }



}
