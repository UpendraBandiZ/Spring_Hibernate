package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {
             int studentId=3;
            session.beginTransaction();



            System.out.println("getting student id="+studentId);

            Student myStudent =session.get(Student.class,studentId);
            System.out.println("get complte"+myStudent);

            //updating
            System.out.println("\nupdating student\n");
            myStudent.setFirstName("scooby");
            //printing updated student
            myStudent =session.get(Student.class,studentId);
            System.out.println("get complte"+myStudent);
            session.getTransaction().commit();

            System.out.println("done!");
        }
        finally {
            //session.close();
            factory.close();
        }

    }
}
