package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try {
            System.out.println("creating new student objecct");
            Student tempStudent=new Student("Daffy","Duck","daffy@luv2code.com");
            session.beginTransaction();
            System.out.println("saving student");
            System.out.println(tempStudent);
            session.save(tempStudent);
            session.getTransaction().commit();

            //reading part
            //finding pk
            System.out.println("saved student genered id="+tempStudent.getId());
            session=factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("getting student id="+tempStudent.getId());
           //actual reading is performing below
            Student myStudent =session.get(Student.class,tempStudent.getId());
            System.out.println("get complete"+myStudent);
            session.getTransaction().commit();

            System.out.println("done!");
        }
        finally {
            //session.close();
            factory.close();
        }

    }
}
