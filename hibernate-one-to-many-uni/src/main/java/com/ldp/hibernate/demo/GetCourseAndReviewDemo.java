package com.ldp.hibernate.demo;

import com.ldp.hibernate.demo.entity.Course;
import com.ldp.hibernate.demo.entity.Instructor;
import com.ldp.hibernate.demo.entity.InstructorDetail;
import com.ldp.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{

            session.beginTransaction();
            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            System.out.println(tempCourse);

            System.out.println(tempCourse.getReviews());

            session.getTransaction().commit();
            System.out.println("Successful");
        }
        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
