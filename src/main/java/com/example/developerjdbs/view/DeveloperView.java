package com.example.developerjdbs.view;

import com.example.developerjdbs.controller.DeveloperController;
import com.example.developerjdbs.model.Developer;

import com.example.developerjdbs.repository.jdbc.JdbcDeveloperRepositoryImpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeveloperView {
    private static final DeveloperController developerController = new DeveloperController(new JdbcDeveloperRepositoryImpl());

    public static void allDevelopers() {
        System.out.println(developerController.onlyDeveloperGetAll());

    }
    public static void developerById(Long id) {
        System.out.println(developerController.onlyDeveloperById(id));
    }
    public static void createDeveloper(Developer developer) {
        System.out.println(developerController.createOnlyDeveloper(developer));
    }
    public static void updateDeveloper(Developer developer, Long id) {
        System.out.println(developerController.updateDeveloperById(developer, id));
    }
    public static boolean deleteDeveloperById(Long id){
    developerController.deleteById(id);
    return true;
    }

}

