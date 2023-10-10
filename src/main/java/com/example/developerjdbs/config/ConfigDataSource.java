package com.example.developerjdbs.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:database.properties")
public class ConfigDataSource {

    private final Environment environment;
    private static Connection connection = null;
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection
                    (
                            Objects.requireNonNull(environment.getProperty("db.url")),
                            environment.getProperty("db.username"),
                            environment.getProperty("db.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public PreparedStatement statement(String sql) throws SQLException {
       connection = getConnection();
        return connection.prepareStatement(sql);
    }
}
