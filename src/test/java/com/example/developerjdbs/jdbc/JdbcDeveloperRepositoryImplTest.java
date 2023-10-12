package com.example.developerjdbs.jdbc;


import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.repository.jdbc.JdbcDeveloperRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
public class JdbcDeveloperRepositoryImplTest {
    @Spy
    private JdbcDeveloperRepositoryImpl developerRepository;

    @Test
    void getAllDevelopers() {
        developerRepository.getAll();

    }

    @Test
    void getDeveloperById() {
        Optional<Developer> someDeveloper = developerRepository.getId(1L);
        assertFalse(someDeveloper.isPresent());
    }
}