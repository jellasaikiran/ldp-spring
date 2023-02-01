package com.ldp.hibernate.demo;

import com.ldp.hibernate.demo.entity.Instructor;
import com.ldp.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{

            Instructor tempInstructor =
                    new Instructor("Madhu", "Patel", "madhu@luv2code.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "http://www.youtube.com/madhuCoders",
                            "Guitar");

            tempInstructor.setInstructorDetail(tempInstructorDetail);
            session.beginTransaction();

            System.out.println("Saving information");
            session.save(tempInstructor);

            session.getTransaction().commit();
            System.out.println("Successful");
        }
        finally {
            sessionFactory.close();
        }

    }
}
