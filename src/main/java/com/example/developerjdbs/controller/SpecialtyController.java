package com.example.developerjdbs.controller;

import com.example.developerjdbs.model.Specialty;
import com.example.developerjdbs.repository.jdbc.JdbcSpecialtyRepositoryImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SpecialtyController {

    private final JdbcSpecialtyRepositoryImpl specialtyRepository;
    public Specialty updateSpecialtyById(Specialty specialty, Long id) {
        return specialtyRepository.update(specialty, id).get();
    }
    public List<Specialty> onlySpecialtyGetAll()  {
        return specialtyRepository.getAll();
    }
    public Specialty onlySpecialtyById( Long id)  {
        return specialtyRepository.getId(id).get();
    }
    public Specialty createOnlySpecialty(Specialty specialty) {
        return specialtyRepository.save(specialty).get();
    }
    public void deleteSpecialtyById( Long id)  {
        specialtyRepository.deleteById(id);
    }

}
