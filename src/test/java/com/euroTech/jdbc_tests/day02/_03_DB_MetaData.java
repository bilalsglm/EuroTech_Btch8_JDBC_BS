package com.euroTech.jdbc_tests.day02;

import org.testng.annotations.Test;

import java.sql.*;

public class _03_DB_MetaData {
    String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=Batch_8_Test;encrypt=true;trustServerCertificate=true";
    String dbUserName="sa";
    String dbPassword="Bilal01";
    String query="select * from employees";

    @Test
    public void Test1() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUserName,dbPassword);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery(query);

        //get the database related data to the dbMetaData object
        DatabaseMetaData dbMetaData = connection.getMetaData();

        System.out.println("dbMetaData.getUserName() = " + dbMetaData.getUserName());
        System.out.println("dbMetaData.getDatabaseProductName() = " + dbMetaData.getDatabaseProductName());
        System.out.println("dbMetaData.getDatabaseProductVersion() = " + dbMetaData.getDatabaseProductVersion());
        System.out.println("dbMetaData.getDriverName() = " + dbMetaData.getDriverName());
        System.out.println("dbMetaData.getDriverVersion() = " + dbMetaData.getDriverVersion());


        resultSet.close();
        statement.close();
        connection.close();

    }
}
