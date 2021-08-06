package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {
            System.out.println("creating new student objecct");
            Student tempStudent=new Student("paul","wall","paul@luv2code.com");
            session.beginTransaction();
            System.out.println("saving student");
            session.save(tempStudent);
            session.getTransaction().commit();
            System.out.println("done!");
        }
        finally {
            //session.close();
            factory.close();
        }

    }
}
