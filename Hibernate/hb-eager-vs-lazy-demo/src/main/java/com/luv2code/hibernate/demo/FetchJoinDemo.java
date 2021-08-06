package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.Course;
import com.lu2code.com.hibernate.demo.entity.Instructor;
import com.lu2code.com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {
            int theId=1;
            session.beginTransaction();
            Query<Instructor> query=session.createQuery("select i from Instructor i "
            + "JOIN FETCH i.courses "+" where i.id=:theInstructorId");
            //setting parameter for query
            query.setParameter("theInstructorId",theId);
            //executing query
            Instructor tempInstructor=query.getSingleResult();
            System.out.println("luv2code: Instructor"+tempInstructor);

          //  System.out.println("luv2code: courses"+tempInstructor.getCourses());
           
            session.getTransaction().commit();
            session.close();
            System.out.println("luv2code :one!");
            System.out.println("luv2code: courses"+tempInstructor.getCourses());
        }
        finally {

            factory.close();
        }

    }
}
