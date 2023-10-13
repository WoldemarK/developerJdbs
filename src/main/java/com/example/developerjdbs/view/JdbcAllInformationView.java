package com.example.developerjdbs.view;

import com.example.developerjdbs.controller.AllInformationController;
import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.repository.jdbc.JdbcAllInformation;

public class JdbcAllInformationView {
    private static final AllInformationController informationController = new AllInformationController(new JdbcAllInformation());

    public static void allInformation() {
        System.out.println(informationController.allInformation());
    }

    public static void getAllInformationById(Long id) {
        System.out.println(informationController.getAllInformationById(id));
    }

    public static void createDevAndAppointSpecialtyId(Developer developer, Long specialtyId) {
        System.out.println(informationController.createDevAndAppointSpecialtyId(developer, specialtyId));
    }
}
