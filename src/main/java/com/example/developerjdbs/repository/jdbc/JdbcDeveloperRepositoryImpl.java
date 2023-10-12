package com.example.developerjdbs.repository.jdbc;

import com.example.developerjdbs.model.Developer;
import com.example.developerjdbs.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.developerjdbs.config.ConfigDataSource.statement;
import static com.example.developerjdbs.util.UtilResultSet.onlyDeveloper;
import static com.example.developerjdbs.util.UtilResultSet.onlyDeveloperById;

@RequiredArgsConstructor
public class JdbcDeveloperRepositoryImpl implements DeveloperRepository {

    private final static String GET_ALL_DEV = "select id, firstName, lastName from developer";
    private final static String SAVE_DEV = "insert into developer(firstName,lastName)values (?,?)";
    private final static String GET_ID = "select firstName,lastName from developer where id=?";
    private final static String DELETE_DEV_ID = "delete from developer where id=?";
    private final static String UPDATE_DEV = "update developer set firstname =?, lastname=? where id=?";
    @Override
    public Optional<Developer> save(Developer developer) {
        try (PreparedStatement statement = statement(SAVE_DEV)) {
            statement.setString(1, developer.getFirstName());
            statement.setString(2, developer.getLastName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(developer);
    }
    @Override
    public Optional<Developer> update(Developer developer, Long id) {
        try (PreparedStatement statement = statement(UPDATE_DEV)) {
            statement.setString(1, developer.getFirstName());
            statement.setString(2, developer.getLastName());
            statement.setLong(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(developer);
    }
    @Override
    public Optional<Developer> getId(Long id) {
        Developer developer = null;
        try (PreparedStatement statement = statement(GET_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                developer = onlyDeveloperById(resultSet,id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(developer);
    }
    @Override
    public List<Developer> getAll() {
        List<Developer> developers = new ArrayList<>();
        try (PreparedStatement statement = statement(GET_ALL_DEV)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                developers.add(onlyDeveloper(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developers;
    }
    @Override
    public void deleteById(Long id) {
        try( PreparedStatement statement = statement(DELETE_DEV_ID)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

