package com.example.developerjdbs.controller;

import com.example.developerjdbs.model.Skill;
import com.example.developerjdbs.repository.jdbc.JdbcSkillRepositoryImpl;
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
@RequestMapping("/v1/skill")
public class SkillController {

    private final JdbcSkillRepositoryImpl skillRepository;

    //localhost:8080/v1/skill/all
    @GetMapping("/all")
    public List<Skill> onlySkillGetAll() {
        return skillRepository.getAll();
    }

    //localhost:8080/v1/skill/get/5
    @GetMapping("/get/{id}")
    public Skill onlySkillById(@PathVariable Long id) {
        return skillRepository.getId(id).get();
    }

    //localhost:8080/v1/skill/create
    @PostMapping("/create")
    public Skill createOnlySkill(@RequestBody Skill skill)  {
        return skillRepository.save(skill).get();
    }

    //localhost:8080/v1/skill/delete/11
    @DeleteMapping("/delete/{id}")
    public void deleteSkillById(@PathVariable Long id) {
        skillRepository.deleteById(id);
    }
    //localhost:8080/v1/skill/update/8
    @PutMapping("/update/{id}")
    public Skill updateSkillById(@RequestBody Skill skill, @PathVariable Long id)  {
        return skillRepository.update(skill, id).get();
    }
}
