package com.ldp.hibernate.demo;

import com.ldp.hibernate.demo.entity.Instructor;
import com.ldp.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{


            session.beginTransaction();

            int theId = 3;
            InstructorDetail tempInstructorDetail =
                    session.get(InstructorDetail.class, theId);

            System.out.println("tempInstructorDetail: " + tempInstructorDetail);

            System.out.println("the associated instructor: " +
                    tempInstructorDetail.getInstructor());

            tempInstructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(tempInstructorDetail);

            session.getTransaction().commit();
            System.out.println("Successful");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
