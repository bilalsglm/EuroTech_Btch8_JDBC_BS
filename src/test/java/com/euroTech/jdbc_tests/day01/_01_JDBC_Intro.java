package com.euroTech.jdbc_tests.day01;

import java.net.ConnectException;
import java.sql.*;

public class _01_JDBC_Intro {
    public static void main(String[] args) throws SQLException {
        //db url
        //bd username
        //db password

        String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=Batch_8_Test;encrypt=true;trustServerCertificate=true";
        String dbUserName="sa";
        String dbPassword="Bilal01";

        //create a db connection
        Connection connection= DriverManager.getConnection(dbUrl,dbUserName,dbPassword);

        //create a statement
        Statement statement = connection.createStatement();

        //run query and get the result on resultSet object
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

        resultSet.close();
        statement.close();
        connection.close();
    }
}
