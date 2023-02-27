package com.ldp.hibernate.demo;

import com.ldp.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{

            session.beginTransaction();
            Course tempCourse = new Course("Pacman - How To Score One Million Points");

            System.out.println("\nSaving the course ...");
            session.save(tempCourse);
            System.out.println("Saved the course: " + tempCourse);

            Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");

            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            System.out.println("\nSaving students ...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("Saved students: " + tempCourse.getStudents());

            session.getTransaction().commit();
            System.out.println("Successful");
        }
        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
