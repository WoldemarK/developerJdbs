package com.example.developerjdbs.repository.jdbc;

import com.example.developerjdbs.config.ConfigDataSource;
import com.example.developerjdbs.model.Specialty;
import com.example.developerjdbs.repository.SpecialtyRepository;
import com.example.developerjdbs.util.UtilResultSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JdbcSpecialtyRepositoryImpl implements SpecialtyRepository {

    private final ConfigDataSource dataSource;
    private final UtilResultSet utilResultSet;
    private final static String GET_ALL_SPECIALTY = "select id, name as SPECIALTY from specialty";
    private final static String SAVE_SPECIALTY = "insert into specialty(name)values (?)";
    private final static String GET_ID = "select * from specialty where id=?";
    private final static String DELETE_SPECIALTY_ID = "delete from specialty where id=?";
    private final static String UPDATE_SPECIALTY = "update specialty set name=? where id=?";

    @Override
    public Optional<Specialty> save(Specialty specialty) throws SQLException {
        PreparedStatement statement = dataSource.statement(SAVE_SPECIALTY);
        statement.setString(1, specialty.getName());
        statement.executeUpdate();
        return Optional.of(specialty);
    }

    @Override
    public Optional<Specialty> update(Specialty specialty, Long id) throws SQLException {
        PreparedStatement statement = dataSource.statement(UPDATE_SPECIALTY);
        statement.setString(1, specialty.getName());
        statement.setLong(2, id);
        statement.executeUpdate();
        return Optional.of(specialty);
    }


    @Override
    public Optional<Specialty> getId(Long id) throws SQLException {
        Specialty specialty = null;
        PreparedStatement statement = dataSource.statement(GET_ID);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            specialty = utilResultSet.onlySpecialtyById(resultSet, id);
        }
        return Optional.ofNullable(specialty);
    }

    @Override
    public List<Specialty> getAll() throws SQLException {
        List<Specialty> specialties = new ArrayList<>();
        PreparedStatement statement = dataSource.statement(GET_ALL_SPECIALTY);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            specialties.add(utilResultSet.onlySpecialty(resultSet));
        }
        return specialties;
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        PreparedStatement statement = dataSource.statement(DELETE_SPECIALTY_ID);
        statement.setLong(1, id);
        statement.executeUpdate();
    }
}
