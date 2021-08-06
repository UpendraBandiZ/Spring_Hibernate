package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {

            session.beginTransaction();
           //query and display
            //displaying all students
            List<Student> theStudents=session.createQuery("from Student").list();
            for(Student tempStudent:theStudents){
                System.out.println(tempStudent);
            }

            //query condition
            theStudents=session.createQuery("from Student s where s.lastName='Doe'").list();
            System.out.println("\n\nstudents with last name Doe\n");
            for(Student tempStudent:theStudents){
                System.out.println(tempStudent);
            }


            theStudents=session.createQuery("from Student s where s.lastName='Doe'"
            +"OR s.firstName='Daffy'").list();
            System.out.println("\n\nstudents with last name Doe or firstName duffy\n");
            for(Student tempStudent:theStudents){
                System.out.println(tempStudent);
            }

            session.getTransaction().commit();

            System.out.println("done!");
        }
        finally {
            //session.close();
            factory.close();
        }

    }
}
