package com.euroTech.jdbc_tests.day01;

import java.sql.*;

public class _02_GettingDataFromBD {
    public static void main(String[] args) throws SQLException {
        String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=Batch_8_Test;encrypt=true;trustServerCertificate=true";
        String dbUserName="sa";
        String dbPassword="Bilal01";
        String query="select * from employees";

        Connection connection= DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        //let´s enter table with next method
        boolean next = resultSet.next();
        System.out.println("next = " + next);

        //getting data from BD by using column name
        //get the firstname of first row
        String firstRowFirstname = resultSet.getString("firstname");
        System.out.println("firstRowFirstname = " + firstRowFirstname);

        // get the lastname of first row
        String firstRowLastname = resultSet.getString("lastname");
        System.out.println("firstRowLastname = " + firstRowLastname);

        //CLASS TASK
        //get the salary of first row as string
        String firstRowSalary = resultSet.getString("salary");
        System.out.println("firstRowSalary = " + firstRowSalary);

        //get the salary of first row as int
        int firstRowSalary_2 = resultSet.getInt("salary");
        System.out.println("firstRowSalary_2 = " + firstRowSalary_2);

        //getting data from db by using column index
        // when we get data from db,indexes always start with 1 NOT 0

        //get firstname
        String firstRowFirstname_2 = resultSet.getString(2);
        System.out.println("firstRowFirstname_2 = " + firstRowFirstname_2);

        //to go to second row, call again next();
        resultSet.next();

        //CLASS TASK
        //get the jobId of second row by using column name and column index
        String secondRorJobId = resultSet.getString("jobId");
        System.out.println("secondRorJobId = " + secondRorJobId);

        String secondRowString = resultSet.getString(6);
        System.out.println("secondRowString = " + secondRowString);


        resultSet.close();
        statement.close();
        connection.close();
    }
}
