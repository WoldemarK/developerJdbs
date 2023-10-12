package com.example.developerjdbs.config;

import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@RequiredArgsConstructor
public class ConfigDataSource {
    private static String URL = "jdbc:postgresql://localhost:5432/dev";
    private static String USERNAME = "user";
    private static String PASSWORD = "123";
    private static Connection connection = null;
    private static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static PreparedStatement statement(String sql) throws SQLException {
        connection = getConnection();
        return connection.prepareStatement(sql);
    }
}
