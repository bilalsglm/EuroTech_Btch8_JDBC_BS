package com.euroTech.jdbc_tests.day01;

import java.sql.*;

public class _03_Practice_1 {
    public static void main(String[] args) throws SQLException {
        String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=Batch_8_Test;encrypt=true;trustServerCertificate=true";
        String dbUserName="sa";
        String dbPassword="Bilal01";
        String query="select * from employees";
        String query_2="SELECT employees.firstName, employees.lastName, employees.email, employees.jobId, employees.salary, departments.departmentName, locations.city, locations.streetAddress\n" +
                "FROM     employees INNER JOIN\n" +
                "                  locations ON employees.locationId = locations.locationId INNER JOIN\n" +
                "                  departments ON employees.departmentId = departments.departmentId\n" +
                "WHERE  (employees.salary > 110000)\n" +
                "ORDER BY employees.firstName DESC";

        String query_3= """
                SELECT employees.firstName, employees.lastName, employees.email, employees.jobId, employees.salary, departments.departmentName, locations.city, locations.streetAddress
                                FROM     employees INNER JOIN
                                                  locations ON employees.locationId = locations.locationId INNER JOIN
                                                  departments ON employees.departmentId = departments.departmentId
                                "WHERE  (employees.salary > 110000)
                                "ORDER BY employees.firstName DESC
                """;

        Connection connection= DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query_2);

        //executeQuery()----- sadece select ile kullanılır
        //executeUpdate()-----insert, create kalan diğer komutlar için kullanılır..

        //CLASS TASK
        //get the first row city data

       resultSet.next();

        System.out.println("resultSet.getString(\"city\") = " + resultSet.getString("city"));
        System.out.println("resultSet.getString(4) = " + resultSet.getString(7));

        //how to go 4th row
        resultSet.next();
        resultSet.next();
        resultSet.next();


        //CLASS TASK get the all data of current row (for loop)
        for (int i = 1; i <=8 ; i++) {
            System.out.println("resultSet.getString(i) = " + resultSet.getString(i));
        }

        //how to take the row which i am currently on.
        int row = resultSet.getRow();
        System.out.println("row = " + row);


        resultSet.close();
        statement.close();
        connection.close();
    }
}
