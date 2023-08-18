package com.articleapp.utill;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/article";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
