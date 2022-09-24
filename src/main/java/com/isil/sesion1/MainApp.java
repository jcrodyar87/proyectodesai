package com.isil.sesion1;

import java.sql.*;

public class MainApp {
    public static void main(String[] args) throws Exception{

        // 1. Cargar driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. Crear conexión
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DESAI",
                "root",
                "root");

        //int resultUpdate = stmt.executeUpdate("UPDATE Users set phone='44445666',city='Rosario' where name='Messi'");

        // 3. Crear statement
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

        // 4. Ejecutar query
        ResultSet resultSet2 = preparedStatement.executeQuery();

        // 5. Recorrer resultados
        while(resultSet2.next()){
            System.out.println(resultSet2.getString("name") + "\n" +
                    resultSet2.getString("phone") + "\n" +
                    resultSet2.getString("city"));
        }
        // 6. Cerrar conexión
        con.close();
    }
}
