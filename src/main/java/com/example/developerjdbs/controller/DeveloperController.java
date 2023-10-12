package com.example.developerjdbs.controller;

import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.repository.jdbc.JdbcDeveloperRepositoryImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DeveloperController {

    private final JdbcDeveloperRepositoryImpl developerRepository;
    public List<Developer> onlyDeveloperGetAll() {
        return developerRepository.getAll();
    }
    public Developer onlyDeveloperById(Long id) {
        return developerRepository.getId(id).get();
    }
    public Developer createOnlyDeveloper(Developer developer) {
        return developerRepository.save(developer).get();
    }
    public Developer updateDeveloperById(Developer developer, Long id) {
        return developerRepository.update(developer, id).get();
    }
    public void deleteById(Long id) {
        developerRepository.deleteById(id);
    }
}
