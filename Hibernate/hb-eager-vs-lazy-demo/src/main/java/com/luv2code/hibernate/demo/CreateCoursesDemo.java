package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.Course;
import com.lu2code.com.hibernate.demo.entity.Instructor;
import com.lu2code.com.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
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
            Instructor tempInstructor=session.get(Instructor.class,theId);
            Course tempCourse1=new Course("Air Guitar-the ultimmate guide");
            Course tempCourse2=new Course("The Pin Ball Master");
            session.save(tempCourse1);
            session.save(tempCourse2);
           tempInstructor.add(tempCourse1);
           tempInstructor.add(tempCourse2);

            session.getTransaction().commit();
            System.out.println("done!");
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
