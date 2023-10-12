package com.example.developerjdbs.view;

import com.example.developerjdbs.controller.DeveloperController;
import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.repository.DeveloperRepository;
import com.example.developerjdbs.repository.jdbc.JdbcDeveloperRepositoryImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DeveloperView {
    private static final DeveloperController developerController = new DeveloperController(new JdbcDeveloperRepositoryImpl());

    private static List<Developer> allDeveloper() {
        return developerController.onlyDeveloperGetAll();
    }

}

