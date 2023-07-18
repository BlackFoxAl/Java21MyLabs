package com.java21.lesson18;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public static void main(String[] arguments) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","uC@123456");
            System.out.println("Database is connected!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
