package com.euroTech.jdbc_tests.day02;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Practice_2 {

    String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=Batch_8_Test;encrypt=true;trustServerCertificate=true";
    String dbUserName="sa";
    String dbPassword="Bilal01";
    String query="select * from employees";
    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        Statement statement=connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        //tabloya girelim
        resultSet.next(); //artık birinci satırdayım.

        //get data of first row
        //loop
        for (int i = 1; i <=10 ; i++) {
            System.out.println("resultSet.getString("+i+") = " + resultSet.getString(i));
        }

        //move to second row
        resultSet.next();//artık ikinci satırdayım
        //resultSet.previous(); // önceki satıra dönüş bu resultSet ile hata verir..

        //CLASS TASK
        //how to get all data from table
        while (resultSet.next()){
            for (int i = 1; i <=10 ; i++) {
                System.out.println(resultSet.getString(i)+" ");
            }
            System.out.println();
        }


        resultSet.close();
        statement.close();
        connection.close();
    }
}
