package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {
            int theId=1;
            session.beginTransaction();

            //creating course



            Student tempStudent=session.get(Student.class,2);


            System.out.println("student"+tempStudent);
            System.out.println("courses"+tempStudent.getCourses());

            //deleting
            System.out.println("deleting student");
            session.delete(tempStudent);
            System.out.println("deleted");

            session.getTransaction().commit();
            System.out.println("done!");
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
