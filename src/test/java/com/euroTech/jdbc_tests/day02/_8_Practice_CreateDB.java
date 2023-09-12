package com.euroTech.jdbc_tests.day02;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _8_Practice_CreateDB {
    String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=Batch_8_Test;encrypt=true;trustServerCertificate=true";
    String dbUserName = "sa";
    String dbPassword = "Bilal01";

    String query1 = "create database bilalDemo ";

    String query2 = "use bilalDemo";
    String query3 = """
            create table branches(
                    departmentId integer primary key,
                    departmentName nvarchar(50) not null
                );
                                
                insert into branches values (100, 'SALES');
                insert into branches values (101, 'MARKETING');
                insert into branches values (102, 'IT');
                insert into branches values (103, 'SECURITY');
                insert into branches values (104, 'TECHNICAL SUPPORT');
                insert into branches values (105, 'UPPER MANAGEMENT');
                insert into branches values (106, 'PUBLIC RELATIONS');
                insert into branches values (107, 'TRAINING');
            """;

    String query4 = " insert into branches values (108, 'HOLIDAY')";

    String query5= " drop database bilalDemo";
    @Test
    public void createDBandTable() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        Statement statement = connection.createStatement();

        statement.executeUpdate(query1);
        statement.executeUpdate(query2);
        statement.executeUpdate(query3);


        statement.close();
        connection.close();
    }

    @Test
    public void addDataToTable() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        Statement statement = connection.createStatement();


        statement.executeUpdate(query2);
        statement.executeUpdate(query4);


        statement.close();
        connection.close();
    }
        @Test
        public void dropTable() throws SQLException {
            Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

            Statement statement = connection.createStatement();


            statement.executeUpdate(query5);


            statement.close();
            connection.close();
    }
}
