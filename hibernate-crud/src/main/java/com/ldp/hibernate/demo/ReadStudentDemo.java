package com.ldp.hibernate.demo;

import com.ldp.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            System.out.println("Getting TempID "+ 1);

            Student myStudent;
            myStudent = session.get( Student.class , 1);

            System.out.println(myStudent);
            session.getTransaction().commit();

            System.out.println("done");

        }
        finally {
            sessionFactory.close();
        }
    }
}
