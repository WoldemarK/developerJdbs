package com.example.developerjdbs.controller;

import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.repository.jdbc.JdbcDeveloperRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/developer")
public class DeveloperController {

    private final JdbcDeveloperRepositoryImpl developerRepository;

    //http://localhost:8080/v1/developer/all
    @GetMapping("/all")
    public List<Developer> onlyDeveloperGetAll() {
        return developerRepository.getAll();
    }

    //http://localhost:8080/v1/developer/get/1
    @GetMapping("/get/{id}")
    public Developer onlyDeveloperById(@PathVariable Long id){
        return developerRepository.getId(id).get();
    }

    //localhost:8080/v1/developer/create
    @PostMapping("/create")
    public Developer createOnlyDeveloper(@RequestBody Developer developer) {
        return developerRepository.save(developer).get();
    }

    //localhost:8080/v1/developer/update/9
    @PutMapping("/update/{id}")
    public Developer updateDeveloperById(@RequestBody Developer developer, @PathVariable Long id){
        return developerRepository.update(developer, id).get();
    }

    //localhost:8080/v1/developer/delete/7
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        developerRepository.deleteById(id);
    }
}
