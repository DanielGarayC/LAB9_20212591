package org.example.lab9.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoBase {
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        String user = "root";
        String pass = "123456";
        String url = "jdbc:mysql://localhost:3306/lab9";

        return DriverManager.getConnection(url, user, pass);
    }
}
