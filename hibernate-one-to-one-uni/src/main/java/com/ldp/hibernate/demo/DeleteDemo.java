package com.ldp.hibernate.demo;

import com.ldp.hibernate.demo.entity.Instructor;
import com.ldp.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{

            session.beginTransaction();
            int theId = 2;
            Instructor tempInstructor =
                    session.get(Instructor.class, theId);

            System.out.println("Found instructor: " + tempInstructor);

            if (tempInstructor != null) {
                System.out.println("Deleting: " + tempInstructor);
                session.delete(tempInstructor);
            }

            System.out.println("Saving information");
            session.delete(tempInstructor);

            session.getTransaction().commit();
            System.out.println("Successful");
        }
        finally {
            sessionFactory.close();
        }

    }
}
