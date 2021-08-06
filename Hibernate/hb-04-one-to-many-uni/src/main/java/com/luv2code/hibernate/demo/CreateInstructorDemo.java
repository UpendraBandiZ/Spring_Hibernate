package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.Course;
import com.lu2code.com.hibernate.demo.entity.Instructor;
import com.lu2code.com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {
            //creating object
            Instructor tempInstructor=new
                    Instructor("susan","public","susanpublic@luv2code.com");
            InstructorDetail tempInstructorDetail=new
                    InstructorDetail("http://www.youtube.com","video game!!!");

            //associating
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();
            System.out.println("saving instructor "+tempInstructor);
            session.save(tempInstructor);//cascade will be appliedd no need to save instructor detail

            session.getTransaction().commit();
            System.out.println("done!");
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
