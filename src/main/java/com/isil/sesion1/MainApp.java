package com.isil.sesion1;

import java.sql.*;

public class MainApp {
    public static void main(String[] args) throws Exception{

        // 1. Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Get a connection to the databasse
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DESAI",
                "root",
                "root");

        // 3. Create a statement
        // 3.1 Statement mantenimiento
        Statement stCreate = con.createStatement();
        //int filasAfectadas = stCreate.executeUpdate("insert into Users VALUES(6, 'Maria','98475525','Quito')");
        int filasAfectadas = stCreate.executeUpdate("UPDATE USERS SET name name='JUAN' WHERE idUser=1");
        System.out.println("Filas afectadas: " + filasAfectadas);

        // 3.2 Statement consulta
        /*PreparedStatement preparedStatement =
                con.prepareStatement("SELECT * FROM Users where name=?");
        preparedStatement.setString(1, "Maria");*/
        PreparedStatement preparedStatement =
                con.prepareStatement("SELECT * FROM Users where idUser=?");
        preparedStatement.setInt(1, 1);

        // 4. Execute a SQL Query
        ResultSet resultSet2 = preparedStatement.executeQuery();

        // 5. Iterate the result set abd print the values
        while(resultSet2.next()){
            System.out.println(resultSet2.getString("name") + ", " +
                    resultSet2.getString("phone") + ", " +
                    resultSet2.getString("city"));
        }
        // 6. Close the result set, statement and the connection
        con.close();
    }
}
