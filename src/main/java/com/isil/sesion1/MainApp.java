package com.isil.sesion1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TEST",
                "root",
                "root");

        Statement stmt = con.createStatement();
        //int resultUpdate = stmt.executeUpdate("UPDATE Users set phone='44445666',city='Rosario' where name='Messi'");

        ResultSet result = stmt.executeQuery("SELECT * FROM Users");

        while(result.next()){
            System.out.println(result.getString(1));
            System.out.println(result.getString(2));
            System.out.println(result.getString(3));
            System.out.println(result.getString("idUser"));
            System.out.println(result.getString("name"));
            System.out.println(result.getString("phone"));
            System.out.println(result.getString("city"));
        }
    }
}
