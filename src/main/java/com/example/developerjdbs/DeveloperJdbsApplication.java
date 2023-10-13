package com.example.developerjdbs;

import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.model.Skill;
import com.example.developerjdbs.model.Specialty;


import static com.example.developerjdbs.view.DeveloperView.allDevelopers;
import static com.example.developerjdbs.view.DeveloperView.createDeveloper;
import static com.example.developerjdbs.view.DeveloperView.deleteDeveloperById;
import static com.example.developerjdbs.view.DeveloperView.developerById;
import static com.example.developerjdbs.view.DeveloperView.updateDeveloper;
import static com.example.developerjdbs.view.JdbcAllInformationView.allInformation;
import static com.example.developerjdbs.view.JdbcAllInformationView.createDevAndAppointSpecialtyId;
import static com.example.developerjdbs.view.JdbcAllInformationView.getAllInformationById;
import static com.example.developerjdbs.view.SkillView.allSkills;
import static com.example.developerjdbs.view.SkillView.createSkill;
import static com.example.developerjdbs.view.SkillView.deleteSkillById;
import static com.example.developerjdbs.view.SkillView.skillById;
import static com.example.developerjdbs.view.SkillView.updateSkill;
import static com.example.developerjdbs.view.SpecialtyView.allSpecialty;
import static com.example.developerjdbs.view.SpecialtyView.createSpecialty;
import static com.example.developerjdbs.view.SpecialtyView.deleteSpecialtyById;
import static com.example.developerjdbs.view.SpecialtyView.specialtyById;
import static com.example.developerjdbs.view.SpecialtyView.updateSpecialty;

public class DeveloperJdbsApplication {

    public static void main(String[] args) {

//DeveloperView
        System.out.println("Вывод всех Developer");
        allDevelopers();

        System.out.println("-----------------------");
        System.out.println("Вывод Developer по ID");
        developerById(1L);

        System.out.println("-----------------------");
        System.out.println("Добавление Developer ");
        createDeveloper(new Developer("Test","Test"));

        System.out.println("-----------------------");
        System.out.println("Обновление Developer ");
        updateDeveloper(new Developer("AAAA","BBBB"),13L);

        System.out.println("-----------------------");
        System.out.println("Удаление Developer по ID");
        System.out.println(deleteDeveloperById(13L));

//SkillView
        System.out.println("Вывод всех Skill");
        allSkills();

        System.out.println("-----------------------");
        System.out.println("Вывод Skill по ID");
        skillById(3L);

        System.out.println("-----------------------");
        System.out.println("Добавление Skill ");
        createSkill(new Skill("Skill1"));

        System.out.println("-----------------------");
        System.out.println("Обновление Skill ");
        updateSkill(new Skill("BBBB"),1L);

        System.out.println("-----------------------");
        System.out.println("Удаление Skill по ID");
        System.out.println(deleteSkillById(2L));

//SkillView
        System.out.println("Вывод всех Specialty");
        allSpecialty();

        System.out.println("-----------------------");
        System.out.println("Вывод Specialty по ID");
        specialtyById(1L);

        System.out.println("-----------------------");
        System.out.println("Добавление Specialty ");
        createSpecialty(new Specialty("Test1"));

        System.out.println("-----------------------");
        System.out.println("Обновление Specialty ");
        updateSpecialty(new Specialty("BBBB"),1L);

        System.out.println("-----------------------");
        System.out.println("Удаление Specialty по ID");
        System.out.println(deleteSpecialtyById(13L));

//JdbcAllInformationView
        System.out.println("Вывод всей информации");
        allInformation();

        System.out.println("-----------------------");
        System.out.println("Вывод все информации по ID Developer");
        getAllInformationById(1L);

        System.out.println("-----------------------");
        System.out.println("Добавление Developer и присвоением Specialty");
        createDevAndAppointSpecialtyId(new Developer("DDD","ddd"),3L);




    }


}
