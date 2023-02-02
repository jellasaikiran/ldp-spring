package com.ldp.hibernate.demo;

import com.ldp.hibernate.demo.entity.Course;
import com.ldp.hibernate.demo.entity.Instructor;
import com.ldp.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{

            session.beginTransaction();
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
            Course tempCourse2 = new Course("The Pinball Masterclass");

            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            session.save(tempCourse1);
            session.save(tempCourse2);

            session.getTransaction().commit();
            System.out.println("Successful");
        }
        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
