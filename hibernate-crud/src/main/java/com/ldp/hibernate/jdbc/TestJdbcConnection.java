package com.ldp.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbcConnection {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";
        try {
            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Success");
        }
        catch (Exception exe) {
            exe.printStackTrace();
        }
    }
}
