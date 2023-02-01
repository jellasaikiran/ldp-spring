package com.ldp.hibernate.demo;

import com.ldp.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            System.out.println("Creating student profile");
            Student tempStudent = new Student("Jella","SaiKiran","jellasaikiran@gmail.com");

            session.beginTransaction();

            System.out.println("Saving information");
            session.save(tempStudent);

            session.getTransaction().commit();
            System.out.println("Successful");
        }
        finally {
            sessionFactory.close();
        }

    }
}
