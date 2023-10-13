package com.example.developerjdbs.controller;

import com.example.developerjdbs.model.Skill;
import com.example.developerjdbs.repository.jdbc.JdbcSkillRepositoryImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SkillController {

    private final JdbcSkillRepositoryImpl skillRepository;
    public List<Skill> onlySkillGetAll() {
        return skillRepository.getAll();
    }
    public Skill onlySkillById(Long id) {
        return skillRepository.getId(id).get();
    }
    public Skill createOnlySkill(Skill skill)  {
        return skillRepository.save(skill).get();
    }
    public void deleteSkillById( Long id) {
        skillRepository.deleteById(id);
    }
    public Skill updateSkillById( Skill skill,  Long id)  {
        return skillRepository.update(skill, id).get();
    }
}
