package org.database;

import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperation extends Base_Class {

    @Test
    public void create_Table() throws SQLException {
       PreparedStatement preparedStatement = con.prepareStatement("create table Employee(id int primary key, name varchar(20), age int)");
       preparedStatement.executeUpdate();
        System.out.println("Table created Successfully");
    }

    @Test
    public void insert_Value() throws SQLException{
        PreparedStatement  preparedStatement = con.prepareStatement("insert into employee values(?,?,?)");
        preparedStatement.setInt(1,101);
        preparedStatement.setString(2,"Namrata");
        preparedStatement.setInt(3,20);
        preparedStatement.executeUpdate();
        System.out.println("Values inserted successfully");
    }

    @Test
    public void update_values() throws SQLException{
        PreparedStatement preparedStatement = con.prepareStatement("update employee set name='kiran' where id = 101");
        preparedStatement.executeUpdate();
        System.out.println("value updated successfully");
    }

    @Test
    public void delete_value() throws SQLException{
        PreparedStatement preparedStatement = con.prepareStatement("delete  from employee where id=101");
        preparedStatement.executeUpdate();
        System.out.println("values deleted successfully");
    }

    @Test
    public void select_All() throws SQLException{
        PreparedStatement preparedStatement = con.prepareStatement("select * from employee");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println("Id : "+id+" Name: "+name+" Age: "+age);
        }
    }

}
