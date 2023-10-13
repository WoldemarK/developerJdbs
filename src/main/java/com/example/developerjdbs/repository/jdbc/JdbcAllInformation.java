package com.example.developerjdbs.repository.jdbc;

import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.model.Specialty;
import lombok.RequiredArgsConstructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.developerjdbs.config.ConfigDataSource.statement;
import static com.example.developerjdbs.util.UtilResultSet.convertAll;
import static com.example.developerjdbs.util.UtilResultSet.convertAllId;

@RequiredArgsConstructor
public class JdbcAllInformation {

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
    public List<Developer> allInformation() {
        List<Developer> developers = new ArrayList<>();
        try (PreparedStatement statement = statement(GET_ALL_INFORMATION)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                developers.add(convertAll(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developers;
    }
    public Developer getAllInformationById(Long devId) {
        Developer developer = null;
        try (PreparedStatement statement = statement(GET_DI)) {
            statement.setLong(1, devId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                developer = convertAllId(resultSet, devId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }
    public Developer createDevAndAppointSpecialtyId(Developer developer, Long specialtyId) {
        Optional<Specialty> specialty = new JdbcSpecialtyRepositoryImpl().getId(specialtyId);
        try (PreparedStatement statement = statement("insert into developer(firstName,lastName,specialtyid)values (?,?,?)")) {
            statement.setString(1, developer.getFirstName());
            statement.setString(2, developer.getLastName());
            developer.setSpecialty(specialty.get());
            statement.setLong(3, developer.getSpecialty().getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }

}
