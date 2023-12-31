package com.example.developerjdbs.repository.jdbc;

import com.example.developerjdbs.config.ConfigDataSource;
import com.example.developerjdbs.model.Specialty;
import com.example.developerjdbs.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.developerjdbs.config.ConfigDataSource.*;
import static com.example.developerjdbs.util.UtilResultSet.onlySpecialty;
import static com.example.developerjdbs.util.UtilResultSet.onlySpecialtyById;


@RequiredArgsConstructor
public class JdbcSpecialtyRepositoryImpl implements SpecialtyRepository {
    private final static String GET_ALL_SPECIALTY = "select id, name as SPECIALTY from specialty";
    private final static String SAVE_SPECIALTY = "insert into specialty(name)values (?)";
    private final static String GET_ID = "select * from specialty where id=?";
    private final static String DELETE_SPECIALTY_ID = "delete from specialty where id=?";
    private final static String UPDATE_SPECIALTY = "update specialty set name=? where id=?";
    @Override
    public Optional<Specialty> save(Specialty specialty) {
        try (PreparedStatement statement = statement(SAVE_SPECIALTY)){
            statement.setString(1, specialty.getName());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.of(specialty);
    }
    @Override
    public Optional<Specialty> update(Specialty specialty, Long id) {
        try (PreparedStatement statement = statement(UPDATE_SPECIALTY)){
            statement.setString(1, specialty.getName());
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.of(specialty);
    }
    @Override
    public Optional<Specialty> getId(Long id) {
        Specialty specialty = null;
        try(PreparedStatement statement = statement(GET_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                specialty = onlySpecialtyById(resultSet, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(specialty);
    }
    @Override
    public List<Specialty> getAll() {
        List<Specialty> specialties = new ArrayList<>();
        try(PreparedStatement statement = statement(GET_ALL_SPECIALTY)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                specialties.add(onlySpecialty(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specialties;
    }
    @Override
    public void deleteById(Long id) {
        try(PreparedStatement statement = statement(DELETE_SPECIALTY_ID)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
