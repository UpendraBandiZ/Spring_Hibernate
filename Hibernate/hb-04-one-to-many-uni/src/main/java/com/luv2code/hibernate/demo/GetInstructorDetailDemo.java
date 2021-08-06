package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.Instructor;
import com.lu2code.com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {


            session.beginTransaction();
            int theId=23;
            InstructorDetail tempInstructorDetail=
                    session.get(InstructorDetail.class,theId);
            System.out.println("tempInstructor detail"+tempInstructorDetail);
            System.out.println("associated Instructor"+tempInstructorDetail.getInstructor());


            session.getTransaction().commit();
            System.out.println("done!");
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            session.close();

            factory.close();
        }

    }
}
