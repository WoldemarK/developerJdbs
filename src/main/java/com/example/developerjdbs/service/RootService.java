package com.example.developerjdbs.service;
import com.example.developerjdbs.config.ConfigDataSource;
import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.model.Skill;
import com.example.developerjdbs.model.Specialty;
import com.example.developerjdbs.repository.jdbc.JdbcDeveloperRepositoryImpl;
import com.example.developerjdbs.repository.jdbc.JdbcSkillRepositoryImpl;
import com.example.developerjdbs.repository.jdbc.JdbcSpecialtyRepositoryImpl;
import com.example.developerjdbs.util.UtilResultSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;;

@Service
@RequiredArgsConstructor
public class RootService {

    private final JdbcSkillRepositoryImpl skillRepository;
    private final JdbcDeveloperRepositoryImpl developerRepository;
    private final JdbcSpecialtyRepositoryImpl specialtyRepository;
    private final UtilResultSet utilResultSet;
    private final ConfigDataSource dataSource;

    private final static String GET_ALL_INFORMATION = """
            select
            d.id,
            d.firstName as firstName,
            d.lastName as lastName,
            sp.name as SPECIALTY,
            sk.name as SKILL
            from developer d
            join specialty sp on d.specialtyId = sp.id,
                    skill sk,
                    developer_skill ds
                    where ds.developerId = d.id
                    and ds.skillId = sk.id
                    group by d.id, d.firstName, d.lastName, sp.name, sk.name
                    ORDER BY id""";
    private final static String GET_DI = """
            select
                d.id,
                d.firstname as firstName,
                d.lastname as lastName,
                s.name as SKILL,
                sp.name as SPECIALTY
            from developer d
                join skill s on s.id=d.specialtyid, 
                specialty sp, 
                developer_skill ds where ds.developerid =d.id 
                and ds.skillid=sp.id
            group by d.id, d.firstname, d.lastname, s.name, sp.name having d.id=?
            """;

    public List<Developer> allInformation() throws SQLException {
        List<Developer> developers = new ArrayList<>();
        PreparedStatement statement = dataSource.statement(GET_ALL_INFORMATION);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            developers.add(utilResultSet.convertAll(resultSet));
        }
        return developers;
    }
    public Developer getAllInformationById(Long devId) throws SQLException {
        Developer developer = null;
        PreparedStatement statement = dataSource.statement(GET_DI);
        statement.setLong(1, devId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            developer = utilResultSet.convertAllId(resultSet, devId);
        }
        return developer;
    }
    public void createDevAndSpecialty(Developer developer, Specialty specialty) {

    }
    public void createDevAndSpecialtyAndSkell(Developer developer, Specialty specialty, Skill skill) {

    }
    public void createDevAndIdSpecialtyAndIdSkill(Developer developer, Long specialtyId, Long skillId) throws SQLException {
        Optional<Specialty> specialty = specialtyRepository.getId(specialtyId);
        Optional<Skill> skill = skillRepository.getId(skillId);
    }
    public void update(Long developerId, Long specialtyId, Long skillId) throws SQLException {
        Optional<Specialty> specialty = specialtyRepository.getId(specialtyId);
        Optional<Skill> skill = skillRepository.getId(skillId);
        Optional<Developer> developer =developerRepository.getId(developerId);
    }
}
