package com.euroTech.jdbc_tests.day02;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _06_DynamicList {
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

        //dataları depolayacağımız list of mapi oluşturalım.
        List<Map<String,Object>> queryData=new ArrayList<>();

        int columnCount=resultSetMetaData.getColumnCount();

        while (resultSet.next()){
            //satır verilerini depolayacağımız map'i oluşturalım
            Map<String,Object> rowMap=new HashMap<>();
            for (int i = 1; i <=columnCount ; i++) {
                rowMap.put(resultSetMetaData.getColumnName(i),resultSet.getString(i));
            }
            queryData.add(rowMap);
        }

        System.out.println("queryData = " + queryData);

        //get the 7th  row firstname
        System.out.println("queryData.get(6).get(\"firstName\") = " + queryData.get(6).get("firstName"));
        Assert.assertEquals(queryData.get(6).get("firstName"),"Simge");

        //get the jobId of last row
        System.out.println("queryData.get(queryData.size()-1).get(\"jobId\") = " + queryData.get(queryData.size() - 1).get("jobId"));

        //3. satırdaki kaydın tüm bilgilerini yazdıralım..
        System.out.println("queryData.get(2) = " + queryData.get(2));


        resultSet.close();
        statement.close();
        connection.close();
    }

}
