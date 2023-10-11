package com.example.developerjdbs.controller;

import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.model.Skill;
import com.example.developerjdbs.model.Specialty;
import com.example.developerjdbs.repository.jdbc.JdbcDeveloperRepositoryImpl;
import com.example.developerjdbs.repository.jdbc.JdbcSkillRepositoryImpl;
import com.example.developerjdbs.repository.jdbc.JdbcSpecialtyRepositoryImpl;
import com.example.developerjdbs.service.RootService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/developer")
public class TestController {

    private final JdbcDeveloperRepositoryImpl developerRepository;
    private final JdbcSkillRepositoryImpl skillRepository;
    private final JdbcSpecialtyRepositoryImpl specialtyRepository;
    private final RootService service;

    //TODO only Developer
    //http://localhost:8080/v1/developer/only/dev/getall/
    @GetMapping("/only/dev/getall/")
    public List<Developer> onlyDeveloperGetAll() {
        return developerRepository.getAll();
    }

    //http://localhost:8080/v1/developer/only/dev/1
    @GetMapping("/only/dev/{id}")
    public Developer onlyDeveloperById(@PathVariable Long id){
        return developerRepository.getId(id).get();
    }

    //localhost:8080/v1/developer/only/dev/
    @PostMapping("/only/dev/")
    public Developer createOnlyDeveloper(@RequestBody Developer developer) {
        return developerRepository.save(developer).get();
    }

    //localhost:8080/v1/developer/only/dev/9
    @PutMapping("/only/dev/{id}")
    public Developer updateDeveloperById(@RequestBody Developer developer, @PathVariable Long id){
        return developerRepository.update(developer, id).get();
    }

    //localhost:8080/v1/developer/only/7
    @DeleteMapping("/only/{id}")
    public void deleteById(@PathVariable Long id){
        developerRepository.deleteById(id);
    }

    //TODO only Skill
    //localhost:8080/v1/developer/only/skill/getall/
    @GetMapping("/only/skill/getall/")
    public List<Skill> onlySkillGetAll() {
        return skillRepository.getAll();
    }

    //localhost:8080/v1/developer/only/skill/5
    @GetMapping("/only/skill/{id}")
    public Skill onlySkillById(@PathVariable Long id) {
        return skillRepository.getId(id).get();
    }

    //localhost:8080/v1/developer/only/skill/
    @PostMapping("/only/skill/")
    public Skill createOnlySkill(@RequestBody Skill skill)  {
        return skillRepository.save(skill).get();
    }

    //localhost:8080/v1/developer/only/skill/11
    @DeleteMapping("/only/skill/{id}")
    public void deleteSkillById(@PathVariable Long id) {
        skillRepository.deleteById(id);
    }

    //localhost:8080/v1/developer/only/skill/8
    @PutMapping("/only/skill/{id}")
    public Skill updateSkillById(@RequestBody Skill skill, @PathVariable Long id)  {
        return skillRepository.update(skill, id).get();
    }

    //TODO only Specialty
    //localhost:8080/v1/developer/only/specialty/update/1
    @PutMapping("/only/specialty/update/{id}")
    public Specialty updateSpecialtyById(@RequestBody Specialty specialty, @PathVariable Long id) {
        return specialtyRepository.update(specialty, id).get();
    }

    //localhost:8080/v1/developer/only/specialty/getall/
    @GetMapping("/only/specialty/getall/")
    public List<Specialty> onlySpecialtyGetAll()  {
        return specialtyRepository.getAll();
    }

    //localhost:8080/v1/developer/only/specialty/3
    @GetMapping("/only/specialty/{id}")
    public Specialty onlySpecialtyById(@PathVariable Long id)  {
        return specialtyRepository.getId(id).get();
    }

    //localhost:8080/v1/developer/only/specialty/
    @PostMapping("/only/specialty/")
    public Specialty createOnlySpecialty(@RequestBody Specialty specialty) {
        return specialtyRepository.save(specialty).get();
    }

    //localhost:8080/v1/developer/only/skill/11
    @DeleteMapping("/only/specialty/{id}")
    public void deleteSpecialtyById(@PathVariable Long id)  {
        specialtyRepository.deleteById(id);
    }

    //TODO RootService
    //localhost:8080/v1/developer/root/all
    @GetMapping("/root/all")
    public List<Developer> allInformation()  {
    return service.allInformation();
    }
    @GetMapping("/root/{id}")
    public Developer getAllInformationById(@PathVariable Long id){
        return service.getAllInformationById(id);
    }
}
