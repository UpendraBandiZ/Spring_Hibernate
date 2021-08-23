package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager)
    {
        entityManager=theEntityManager;
    }
    @Override
    public List<Employee> findAll() {

        Query theQuery=entityManager.createQuery("from Employee");
        List<Employee> employees=theQuery.getResultList();


        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee =entityManager.find(Employee.class,theId);
        return theEmployee ;
    }

    @Override
    public void save(Employee theEmployee) {

        Employee dbEmployee=entityManager.merge(theEmployee);
        //update id from db so we can get generated id for save/insert
        dbEmployee.setId(dbEmployee.getId());


    }

    @Override
    public void deleteById(int theId) {
        Query query=entityManager.createQuery("delete from Employee where id=:employeeId");
     query.setParameter("employeeId",theId);
     query.executeUpdate();
    }
}
