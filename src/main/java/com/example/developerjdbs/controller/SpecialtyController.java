package com.example.developerjdbs.controller;

import com.example.developerjdbs.model.Specialty;
import com.example.developerjdbs.repository.jdbc.JdbcSpecialtyRepositoryImpl;
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
@RequestMapping("/v1/specialty")
public class SpecialtyController {

    private final JdbcSpecialtyRepositoryImpl specialtyRepository;

    //localhost:8080/v1/specialty/update/1
    @PutMapping("/update/{id}")
    public Specialty updateSpecialtyById(@RequestBody Specialty specialty, @PathVariable Long id) {
        return specialtyRepository.update(specialty, id).get();
    }

    //localhost:8080/v1/specialty/get
    @GetMapping("/get")
    public List<Specialty> onlySpecialtyGetAll()  {
        return specialtyRepository.getAll();
    }

    //localhost:8080/v1/specialty/get/3
    @GetMapping("/get/{id}")
    public Specialty onlySpecialtyById(@PathVariable Long id)  {
        return specialtyRepository.getId(id).get();
    }

    //localhost:8080/v1/specialty/create
    @PostMapping("/create")
    public Specialty createOnlySpecialty(@RequestBody Specialty specialty) {
        return specialtyRepository.save(specialty).get();
    }

    //localhost:8080/v1/specialty/delete/11
    @DeleteMapping("/delete/{id}")
    public void deleteSpecialtyById(@PathVariable Long id)  {
        specialtyRepository.deleteById(id);
    }

}
