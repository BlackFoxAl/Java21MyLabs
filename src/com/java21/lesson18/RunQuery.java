package com.java21.lesson18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RunQuery {
    public static void main(String[] arguments) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","uC@123456");
            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from tables_priv");
            System.out.println("Database is connected!");
            while (rs.next()) {
                String query = rs.getString(1) + "," + rs.getString(2) +
                        "," + rs.getString(3) + "," +rs.getString(4) +
                        "," + rs.getString(5);
                System.out.println(query);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
