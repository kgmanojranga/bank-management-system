package com.manoj;
import java.sql.*;

public class Conn {

    Connection con;
    Statement st;
    String url = "jdbc:mysql://localhost:3306/bankmanagementsystem";
    String username = "root";
    String password = "root";
    public Conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection( url, username, password);
            st = con.createStatement();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
