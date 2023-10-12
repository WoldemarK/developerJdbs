package com.example.developerjdbs.util;

import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.model.Skill;
import com.example.developerjdbs.model.Specialty;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public class UtilResultSet {
    public static Developer convertAll(ResultSet resultSet) throws SQLException {
        return Developer.builder()
                .id(resultSet.getLong("id"))
                .firstName(resultSet.getString("firstName"))
                .lastName(resultSet.getString("lastName"))

                .specialty(new Specialty().toBuilder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("SPECIALTY"))
                        .build())

                .skills(List.of(new Skill().toBuilder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("SKILL"))
                        .build()))
                .build();
    }
    public static Developer convertAllId(ResultSet resultSet,Long id) throws SQLException {
        return Developer.builder()
                .id(id)
                .firstName(resultSet.getString("firstName"))
                .lastName(resultSet.getString("lastName"))

                .specialty(new Specialty().toBuilder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("SPECIALTY"))
                        .build())

                .skills(List.of(new Skill().toBuilder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("SKILL"))
                        .build()))
                .build();
    }
    public Developer convertDeveloperAndSpecialty(ResultSet resultSet) throws SQLException {
        return Developer.builder()
                .id(resultSet.getLong("id"))
                .firstName(resultSet.getString("firstName"))
                .lastName(resultSet.getString("lastName"))

                .specialty(Specialty.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("SPECIALTY"))
                        .build())
                .build();
    }
    //TODO this only Developer
    public static Developer onlyDeveloper(ResultSet resultSet) throws SQLException {
        return Developer.builder()
                .id(resultSet.getLong("id"))
                .firstName(resultSet.getString("firstName"))
                .lastName(resultSet.getString("lastName"))
                .build();
    }
    public static Developer onlyDeveloperById(ResultSet resultSet, Long id) throws SQLException {
        return Developer.builder()
                .id(id)
                .firstName(resultSet.getString("firstName"))
                .lastName(resultSet.getString("lastName"))
                .build();
    }
    //TODO this only Specialty
    public static Specialty onlySpecialty(ResultSet resultSet) throws SQLException {
        return Specialty.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("SPECIALTY"))
                .build();
    }
    public static Specialty onlySpecialtyById(ResultSet resultSet, Long id) throws SQLException {
        return Specialty.builder()
                .id(id)
                .name(resultSet.getString("name"))
                .build();
    }
    //TODO this only Skill
    public static Skill onlySkillById(ResultSet resultSet, Long id) throws SQLException {
        return Skill.builder()
                .id(id)
                .name(resultSet.getString("name"))
                .build();
    }
    public static Skill onlySkill(ResultSet resultSet) throws SQLException {
        return Skill.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("SKILL"))
                .build();
    }
}
