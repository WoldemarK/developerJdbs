package com.example.developerjdbs.view;

import com.example.developerjdbs.controller.SkillController;
import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.model.Skill;
import com.example.developerjdbs.repository.jdbc.JdbcSkillRepositoryImpl;

public class SkillView {
    private static final SkillController developerController = new SkillController(new JdbcSkillRepositoryImpl());
    public static void allSkills() {
        System.out.println(developerController.onlySkillGetAll());

    }
    public static void skillById(Long id) {
        System.out.println(developerController.onlySkillById(id));
    }
    public static void createSkill(Skill skill) {
        System.out.println(developerController.createOnlySkill(skill));
    }
    public static void updateSkill(Skill skill, Long id) {
        System.out.println(developerController.updateSkillById(skill, id));
    }
    public static boolean deleteSkillById(Long id){
        developerController.deleteSkillById(id);
        return true;
    }
}
