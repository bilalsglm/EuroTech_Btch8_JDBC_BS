package com.euroTech.jdbc_tests.day02;

import org.testng.annotations.Test;

import java.sql.*;

public class _02_MovingCursorOnTheTable {
    String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=Batch_8_Test;encrypt=true;trustServerCertificate=true";
    String dbUserName="sa";
    String dbPassword="Bilal01";
    String query="select * from employees";

    @Test
    public void Test1() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUserName,dbPassword);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery(query);

        // how go to directly 5th row ---> use absolute()int rowNumber

        boolean absolute = resultSet.absolute(5);  //eğer beşinci satır varsa beni oraya götür.
        System.out.println("absolute = " + absolute);
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        //Class Task
        //move to 11th row and get the last
        boolean absolute1 = resultSet.absolute(11);
        System.out.println("absolute1 = " + absolute1);
        System.out.println("resultSet.getRow() = " + resultSet.getRow());
        System.out.println("resultSet.getString() = " + resultSet.getString("lastname"));

        //how to go firts row
        resultSet.first();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        //Class Task
        //how to find how many rows do we have
        resultSet.last();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        //son satırdayken gene last() metodunu kullanırsam hata almam
        resultSet.last();
        boolean last = resultSet.isLast(); //eğer son satırdaysanız true, değilseniz false döner. first ile de kullanılır.
        System.out.println("last = " + last);

        //how to go to previous row (önceki satıra nasıl giderim)
        resultSet.previous();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        //tablonun ustten disina nasil ciakrim
        resultSet.beforeFirst();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        //ilk satira nasil gecerim
        resultSet.next();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        //alttan disina nasil cikarim
        resultSet.afterLast();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        //son satira nasil donerim
        resultSet.previous();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        resultSet.close();
        statement.close();
        connection.close();
    }
}
