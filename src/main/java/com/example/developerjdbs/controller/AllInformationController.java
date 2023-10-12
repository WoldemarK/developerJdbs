package com.example.developerjdbs.controller;

import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.repository.jdbc.JdbcAllInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/information")
public class AllInformationController {

    private final JdbcAllInformation service;

    //localhost:8080/v1/information/all
    @GetMapping("/all")
    public List<Developer> allInformation()  {
    return service.allInformation();
    }
    @GetMapping("/root/{id}")
    public Developer getAllInformationById(@PathVariable Long id){
        return service.getAllInformationById(id);
    }
}
