package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.Course;
import com.lu2code.com.hibernate.demo.entity.Instructor;
import com.lu2code.com.hibernate.demo.entity.InstructorDetail;
import com.lu2code.com.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {
            int theId=10;
            session.beginTransaction();

            //creating course
            Course tempCourse=session.get(Course.class,theId);
            System.out.println("course"+tempCourse);
            System.out.println(tempCourse.getReviews());
            session.getTransaction().commit();
            System.out.println("done!");
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
