package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForManyDemo {
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




            //create more courses
            System.out.println("adding students to courses");
            Course tempCourse1=new Course(" Rbbik's cube");
            Course tempCourse2=new Course("Atari 3200");
            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);
            System.out.println("saving courses");
            session.save(tempCourse1);
            session.save(tempCourse2);

            session.getTransaction().commit();
            System.out.println("done!");
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
