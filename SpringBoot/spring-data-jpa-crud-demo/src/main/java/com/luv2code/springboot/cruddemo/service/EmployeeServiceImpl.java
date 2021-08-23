package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl( EmployeeRepository theEmployeeRepository)
    {
        employeeRepository=theEmployeeRepository;
    }

    @Override

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override

    public Employee findById(int theId) {
        //optional pattern insteed of having to check for nulls
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee employee=null;
        if(result.isPresent())
        {
            employee=result.get();
        }
        else{
            throw new RuntimeException("employee not find"+theId);
        }
        return employee;
    }

    @Override

    public void save(Employee employee) {

        employeeRepository.save(employee);
    }

    @Override

    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);

    }
}
