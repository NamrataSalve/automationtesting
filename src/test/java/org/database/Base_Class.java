package org.database;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Base_Class {
    public static Connection con ;
    @BeforeMethod
    public Connection setUp () throws SQLException{
        try{
            String url = "jdbc:mysql://localhost:3306/db_testing";
            String username = "root";
            String password = "root";
            con = DriverManager.getConnection(url,username,password);

        }catch (SQLException e){
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
    @AfterMethod
    public void tearDown() throws SQLException{
        con.close();
    }
}
