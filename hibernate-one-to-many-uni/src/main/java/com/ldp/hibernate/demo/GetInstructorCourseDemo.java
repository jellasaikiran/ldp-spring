package com.ldp.hibernate.demo;

import com.ldp.hibernate.demo.entity.Course;
import com.ldp.hibernate.demo.entity.Instructor;
import com.ldp.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCourseDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{

            session.beginTransaction();
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("Instructor: " + tempInstructor);

            System.out.println("Courses: " + tempInstructor.getCourses());
            session.getTransaction().commit();
            System.out.println("Successful");
        }
        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
