package com.bookit.step_definitions;

import com.bookit.utilities.DBUObject;
import com.bookit.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class test {
    DBUObject dbuObject = new DBUObject();

//host: 18.233.97.71
//port: 3306
//user: library1_client
//password: WVF4NdGXCKHeE6VQ
//databse: library1


    @Test
    public void test_BookIt() {
        dbuObject.createConnection();
        dbuObject.runQuery("select count(*) from users");
        String countUsers = dbuObject.getFirstRowFirstColumn();
        String expectedUsers = "1987";

        //   Assert.assertEquals();
        System.out.println(countUsers);
        dbuObject.destroy();
    }


    @Test
    public void testLibrary() throws SQLException {


        dbuObject.createConnection();
        dbuObject.runQuery("SELECT  email FROM users WHERE full_name = 'john hanna'");

        String actualResult = dbuObject.getFirstRowFirstColumn();

        String expectedEmail = "john.hanna@gmail.com";
        Assert.assertTrue(expectedEmail.equals(actualResult));


    }
}
