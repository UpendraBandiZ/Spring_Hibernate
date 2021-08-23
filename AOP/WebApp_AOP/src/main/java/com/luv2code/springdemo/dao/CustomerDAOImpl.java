package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class CustomerDAOImpl implements  CustomerDAO{
    //inject session for db
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        //getting current session

        Session session=sessionFactory.getCurrentSession();

        Query<Customer> theQuery=session.createQuery("from Customer order by firstName",Customer.class);

        List<Customer> customers=theQuery.getResultList();


        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
         Session session=sessionFactory.getCurrentSession();

         session.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        Session session=sessionFactory.getCurrentSession();
        Customer tempCustomer=session.get(Customer.class,theId);
        return tempCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
         Session session=sessionFactory.getCurrentSession();
         Query theQuery=session.createQuery("delete from Customer where id=:theCustomerId");
         theQuery.setParameter("theCustomerId",theId);
         theQuery.executeUpdate();
    }
}
