package com.example.developerjdbs.controller;

import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.repository.jdbc.JdbcAllInformation;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class AllInformationController {

    private final JdbcAllInformation jdbcAllInformation;
    public List<Developer> allInformation()  {
    return jdbcAllInformation.allInformation();
    }
    public Developer getAllInformationById(Long id){
        return jdbcAllInformation.getAllInformationById(id);
    }
}
