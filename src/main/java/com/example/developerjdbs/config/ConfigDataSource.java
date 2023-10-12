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

    private static final Environment environment = null;
    private static Connection connection = null;
    private static Connection getConnection() {
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
    public static PreparedStatement statement(String sql) throws SQLException {
       connection = getConnection();
        return connection.prepareStatement(sql);
    }
}
