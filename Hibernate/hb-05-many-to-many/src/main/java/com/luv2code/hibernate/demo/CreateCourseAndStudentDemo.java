package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {
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
            Course tempCourse=new Course("Pacman-how to score one million points");

            System.out.println("saaving the course");
            session.save(tempCourse);
            System.out.println("saved course"+tempCourse);

            Student tempStudent1=new Student("John","doe","john@luv2code.com");
            Student tempStudent2=new Student("Mary","public","mary@luv2code.com");
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            System.out.println("saving students");
            session.save(tempStudent1);
            session.save(tempStudent2);

            System.out.println("saved students"+tempCourse.getStudents());


            session.getTransaction().commit();
            System.out.println("done!");
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
