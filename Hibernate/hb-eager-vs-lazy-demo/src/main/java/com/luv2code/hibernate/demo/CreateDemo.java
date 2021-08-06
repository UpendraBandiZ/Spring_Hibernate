package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.Instructor;
import com.lu2code.com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {
            //create and associate objects
          /*  Instructor tempInstructor=new
                    Instructor("chad","darby","darby@luv2code.com");
            InstructorDetail tempInstructorDetail=new
                    InstructorDetail("http://www.luv2code.com/youtube","Luv 2 code!!!");

           */
            Instructor tempInstructor=new
                    Instructor("madhu","patel","madhu@luv2code.com");
            InstructorDetail tempInstructorDetail=new
                    InstructorDetail("http://www.youtube.com","music!!!");

            //associating
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();
            System.out.println("saving instructor "+tempInstructor);
            session.save(tempInstructor);//cascade will be appliedd no need to save instructor detail

            session.getTransaction().commit();
            System.out.println("done!");
        }
        finally {
            //session.close();
            factory.close();
        }

    }
}
