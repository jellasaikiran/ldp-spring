package com.ldp.hibernate.demo;

import com.ldp.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{

            session.beginTransaction();
            List<Student> studentList = session.createQuery("from Student").list();

            for (Student i: studentList){
                System.out.println(i);
            }

            System.out.println("\n\n\n");
            studentList = session.createQuery("from Student s where s.lastName ='SaiKiran'").list();

            for (Student i: studentList){
                System.out.println(i);
            }
            session.getTransaction().commit();
            System.out.println("Successful");
        }
        finally {
            sessionFactory.close();
        }

    }
}
