package com.example.developerjdbs.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConfigDataSourceTest {
    private Connection getNewConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/dev";
        String user = "user";
        String passwd = "123";
        return DriverManager.getConnection(url, user, passwd);
    }

    @Test
    public void shouldGetJdbcConnection() throws SQLException {
        try (Connection connection = getNewConnection()) {
            Assertions.assertTrue(connection.isValid(1));
            Assertions.assertFalse(connection.isClosed());
        }
    }
}