package com.ldp.hibernate.demo;

import com.ldp.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            int studentId = 6;

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Deleting");
            session.delete(myStudent);


            session.getTransaction().commit();
            System.out.println("Successful");
        }
        finally {
            sessionFactory.close();
        }

    }
}
