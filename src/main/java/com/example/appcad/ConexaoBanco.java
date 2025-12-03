package com.example.appcad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static final String URL = "jdbc:mariadb://192.168.0.51:3306/forcavendas";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException {
        try {
            // Registrar o driver (opcional em versões mais recentes do JDBC)
            Class.forName("org.mariadb.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do MariaDB não encontrado", e);
        }
    }
}