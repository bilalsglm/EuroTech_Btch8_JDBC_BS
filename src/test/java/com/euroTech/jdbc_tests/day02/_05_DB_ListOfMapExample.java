package com.euroTech.jdbc_tests.day02;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _05_DB_ListOfMapExample {
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

        List<Map<String,Object>> queryData=new ArrayList<>();

        Map<String,Object> row1=new HashMap<>();
        row1.put("firtsname","Mehmet");
        row1.put("lastname","Altas");
        row1.put("salary","100000");
        row1.put("jobId","Teacher");

        Map<String,Object> row2=new HashMap<>();
        row2.put("firtsname","Ekrem");
        row2.put("lastname","Yavas");
        row2.put("salary","200000");
        row2.put("jobId","Engineer");

        System.out.println("row1 = " + row1);
        System.out.println("row2 = " + row2);

        queryData.add(row1);
        queryData.add(row2);
        System.out.println("queryData = " + queryData);

        //get the first row lastname
        System.out.println("queryData.get(0).get(\"lastname\") = " + queryData.get(0).get("lastname"));

        //get the second row salary
        System.out.println("queryData.get(1).get(\"salary\") = " + queryData.get(1).get("salary"));

        System.out.println("--------------------------------------");

        //how to fill list of map with info that comes from database

        resultSet.next();

        //create a map that will store first row info -- ilk satırın bilgilerini depolayacak mapi oluştur
        List<Map<String,Object>> queryDataFromDB=new ArrayList<>();

        Map<String,Object>row1FromDB=new HashMap<>();
        row1FromDB.put(resultSetMetaData.getColumnName(1),resultSet.getString(1));
        row1FromDB.put(resultSetMetaData.getColumnName(2),resultSet.getString(2));
        row1FromDB.put(resultSetMetaData.getColumnName(3),resultSet.getString(3));
        row1FromDB.put(resultSetMetaData.getColumnName(4),resultSet.getString(4));

        System.out.println("row1FromDB = " + row1FromDB);

        resultSet.next();

        Map<String,Object>row2FromDB=new HashMap<>();
        row2FromDB.put(resultSetMetaData.getColumnName(1),resultSet.getString(1));
        row2FromDB.put(resultSetMetaData.getColumnName(2),resultSet.getString(2));
        row2FromDB.put(resultSetMetaData.getColumnName(3),resultSet.getString(3));
        row2FromDB.put(resultSetMetaData.getColumnName(4),resultSet.getString(4));

        System.out.println("row1FromDB = " + row2FromDB);

        queryDataFromDB.add(row1FromDB);
        queryDataFromDB.add(row2FromDB);

        System.out.println("queryDataFromDB = " + queryDataFromDB);

        //get the Alperen's jobId
        System.out.println("queryDataFromDB.get(0).get(\"jobId\") = " + queryDataFromDB.get(1).get("jobId"));


        resultSet.next();

        Map<String,Object>row3FromDB=new HashMap<>();
        row3FromDB.put(resultSetMetaData.getColumnName(1),resultSet.getString("firstname"));
        row3FromDB.put(resultSetMetaData.getColumnName(2),resultSet.getString("lastname"));
        row3FromDB.put(resultSetMetaData.getColumnName(3),resultSet.getString(resultSetMetaData.getColumnName(3)));
        row3FromDB.put(resultSetMetaData.getColumnName(4),resultSet.getString(resultSetMetaData.getColumnName(4)));

        queryDataFromDB.add(row3FromDB);

        System.out.println("row3FromDB = " + row3FromDB);


        resultSet.close();
        statement.close();
        connection.close();
    }

}
