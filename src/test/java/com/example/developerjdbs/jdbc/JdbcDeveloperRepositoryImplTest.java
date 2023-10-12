package com.example.developerjdbs.jdbc;

import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.repository.jdbc.JdbcDeveloperRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class JdbcDeveloperRepositoryImplTest {
    @Test
    void developerEmptyIfNoDeveloperAdded() {
        JdbcDeveloperRepositoryImpl developerRepository = new JdbcDeveloperRepositoryImpl();
        List<Developer>developers = developerRepository.getAll();
        assertFalse(developers.isEmpty());
    }


}