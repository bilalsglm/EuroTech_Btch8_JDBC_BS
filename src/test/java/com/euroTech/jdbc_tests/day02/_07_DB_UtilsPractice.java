package com.euroTech.jdbc_tests.day02;

import com.euroTech.utilities.DBUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class _07_DB_UtilsPractice {
    @Test
    public void oneSingleRow(){

        //baglantiyi olusturur
        DBUtils.createConnection();

        //ilk satırı bir liste alalım
        List<Object> rowList = DBUtils.getRowList("select firstName,lastName,email,jobId from employees");

        System.out.println("rowList = " + rowList);

        //ilk satırı bir mape alalım
        Map<String, Object> rowMap = DBUtils.getRowMap("select firstName,lastName,email,jobId from employees");
        System.out.println("rowMap = " + rowMap);

        //bağlantıyı kapatalım
        DBUtils.destroy();

    }

    @Test
    public void getDataToListOfMap(){

        //bağlantıyı oluşturur.
        DBUtils.createConnection();

        //list of mape bütün tablo bilgisini alalım..
        List<Map<String, Object>> queryResultMap = DBUtils.getQueryResultMap("select firstName,lastName,email,jobId from employees");
        System.out.println("queryResultMap = " + queryResultMap);

        //get the firtsname of 5th row
        String expected="Fethi";
        String actual= (String) queryResultMap.get(4).get("firstName");

        Assert.assertEquals(actual,expected);

        //bağlantıyı kapatalım
        DBUtils.destroy();
    }
}
