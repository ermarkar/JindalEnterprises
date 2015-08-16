package com.jindal.database;

import java.sql.*;

public class ConnectDB {

    static Connection connection = null;

    public static Connection openConnection() {
        try {
            String userName = "root";
            String password = "pass";
            String url = "jdbc:mysql://127.0.0.1:3306/JindalEnterprises";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = (Connection) DriverManager.getConnection(url, userName, password);
            if (connection == null) {
                System.err.println("Cannot connect to database server");
            }
            return connection;
        } catch (Exception e) {
            System.err.println("Cannot connect to database server" + e);
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                System.err.println("Cannot close the connection to database server");
            }
        }
    }
}
