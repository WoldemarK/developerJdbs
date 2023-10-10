package com.example.developerjdbs.jdbc;


import com.example.developerjdbs.config.ConfigDataSource;
import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.repository.jdbc.JdbcDeveloperRepositoryImpl;
import com.example.developerjdbs.util.UtilResultSet;
import lombok.RequiredArgsConstructor;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

@RequiredArgsConstructor
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class JdbcDeveloperRepositoryImplTest {
@Mock
    private JdbcDeveloperRepositoryImpl developerRepository;
    @Mock
    private ConfigDataSource dataSource;
    @Mock
    private UtilResultSet resultSet;


    @BeforeEach
    void prepare() {
        developerRepository = new JdbcDeveloperRepositoryImpl(dataSource, resultSet);
    }

    @Test
    void usersEmptyIfNoUserAdded() throws SQLException {
    List<Developer>developers=developerRepository.getAll();


    }
}