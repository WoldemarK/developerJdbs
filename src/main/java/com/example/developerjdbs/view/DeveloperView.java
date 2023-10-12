package com.example.developerjdbs.view;

import com.example.developerjdbs.controller.DeveloperController;
import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.repository.DeveloperRepository;
import com.example.developerjdbs.repository.jdbc.JdbcDeveloperRepositoryImpl;
import com.example.developerjdbs.util.UtilResultSet;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DeveloperView {
    private final UtilResultSet resultSet;
    private final   DeveloperController developerController;
    private final DeveloperRepository developerRepository = new JdbcDeveloperRepositoryImpl(resultSet);

    public List<Developer> onlyDeveloperGetAll(){
      return   developerController.onlyDeveloperGetAll();
    }


}
