package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {
            System.out.println("creating new student objeccts");
            Student tempStudent1=new Student("Jhon","Doe","john@luv2code.com");
            Student tempStudent2=new Student("Mary","Public","mary@luv2code.com");
            Student tempStudent3=new Student("Bonita","Applebum","bonita@luv2code.com");

            session.beginTransaction();

            System.out.println("saving students");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();
            System.out.println("done!");
        }
        finally {
            //session.close();
            factory.close();
        }
    }
}
