package com.euroTech.jdbc_tests.day02;

import org.testng.annotations.Test;

import java.sql.*;

public class _04_DB_ResultSet_MetaData {
    String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=Batch_8_Test;encrypt=true;trustServerCertificate=true";
    String dbUserName="sa";
    String dbPassword="Bilal01";
    String query= """
            select firstName,lastName,email,jobId
            from employees
            where managerId is not null;
            """;

    @Test
    public void Test() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUserName,dbPassword);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery(query);

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        //sütun sayısını nasıl alırım
        int columnCount = resultSetMetaData.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        //get column name
        String firstColumnName = resultSetMetaData.getColumnName(1);
        System.out.println("firstColumnName = " + firstColumnName);

        //Class Task
        //get all column names dynamically
        for (int i = 1; i <=columnCount ; i++) {
            System.out.println("resultSetMetaData.getColumnName("+i+") = " + resultSetMetaData.getColumnName(i));

        }


        resultSet.close();
        statement.close();
        connection.close();
    }

}
