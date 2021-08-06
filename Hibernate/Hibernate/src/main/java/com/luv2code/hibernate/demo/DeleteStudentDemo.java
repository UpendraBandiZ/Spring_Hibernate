package com.luv2code.hibernate.demo;

import com.lu2code.com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {


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


            //delete
          //  System.out.println("deleting student");
          //  session.delete(myStudent);


            System.out.println("deleting student id="+studentId);
            session.createQuery("delete from Student where id=3").executeUpdate();
            session.getTransaction().commit();
            System.out.println("done!");
        }
        finally {
            //session.close();
            factory.close();
        }

    }
}
