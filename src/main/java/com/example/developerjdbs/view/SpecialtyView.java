package com.example.developerjdbs.view;

import com.example.developerjdbs.controller.SkillController;
import com.example.developerjdbs.controller.SpecialtyController;
import com.example.developerjdbs.model.Skill;
import com.example.developerjdbs.model.Specialty;

import com.example.developerjdbs.repository.jdbc.JdbcSpecialtyRepositoryImpl;

public class SpecialtyView {
    private static final SpecialtyController specialtyController = new SpecialtyController(new JdbcSpecialtyRepositoryImpl());
    public static void allSpecialty() {
        System.out.println(specialtyController.onlySpecialtyGetAll());

    }
    public static void specialtyById(Long id) {
        System.out.println(specialtyController.onlySpecialtyById(id));
    }
    public static void createSpecialty(Specialty specialty) {
        System.out.println(specialtyController.createOnlySpecialty(specialty));
    }
    public static void updateSpecialty(Specialty specialty, Long id) {
        System.out.println(specialtyController.updateSpecialtyById(specialty, id));
    }
    public static boolean deleteSpecialtyById(Long id){
        specialtyController.deleteSpecialtyById(id);
        return true;
    }
}
