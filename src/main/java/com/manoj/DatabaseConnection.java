package com.manoj;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class DatabaseConnection {

    Connection con;
    Statement st;
    String url = "jdbc:mysql://localhost:3306/bankmanagementsystem";
    String username = "root";
    String password = "root";
    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection( url, username, password);
            st = con.createStatement();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
