package com.example.developerjdbs.jdbc;

import com.example.developerjdbs.controller.DeveloperController;
import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.repository.jdbc.JdbcDeveloperRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class JdbcDeveloperRepositoryImplTest {
    @Mock
    private DeveloperController developerController;
    @Mock
    private JdbcDeveloperRepositoryImpl developerRepository;
    @BeforeEach void setUp(){
        developerController = new DeveloperController(developerRepository);
    }
    @Test
    void getAll(){
     developerController.onlyDeveloperGetAll();
     verify(developerRepository.getAll());

    }
}