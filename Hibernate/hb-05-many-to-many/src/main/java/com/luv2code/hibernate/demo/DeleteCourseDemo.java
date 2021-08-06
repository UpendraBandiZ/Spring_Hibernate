package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
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
            int theId=10;
            session.beginTransaction();

            //creating course



            Course tempCourse=session.get(Course.class,theId);


            System.out.println("deleting course");
            session.delete(tempCourse);



            session.getTransaction().commit();
            System.out.println("done!");
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
