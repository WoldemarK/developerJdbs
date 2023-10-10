package com.example.developer.repository.jdbc;

import com.example.developer.config.ConfigDataSource;
import com.example.developer.model.Developer;
import com.example.developer.repository.DeveloperRepository;
import com.example.developer.util.UtilResultSet;
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
public class JdbcDeveloperRepositoryImpl implements DeveloperRepository {

    private final ConfigDataSource dataSource;
    private final UtilResultSet utilResultSet;
    private final static String GET_ALL_DEV = "select id, firstName, lastName from developer";
    private final static String SAVE_DEV = "insert into developer(firstName,lastName)values (?,?)";
    private final static String GET_ID = "select firstName,lastName from developer where id=?";
    private final static String DELETE_DEV_ID = "delete from developer where id=?";
    private final static String UPDATE_DEV = "update developer set firstname =?, lastname=? where id=?";

    @Override
    public Optional<Developer> save(Developer developer) throws SQLException {
        PreparedStatement statement = dataSource.statement(SAVE_DEV);
        statement.setString(1, developer.getFirstName());
        statement.setString(2, developer.getLastName());
        statement.executeUpdate();
        return Optional.of(developer);
    }

    @Override
    public Optional<Developer> update(Developer developer, Long id) throws SQLException {

        PreparedStatement statement = dataSource.statement(UPDATE_DEV);
        statement.setString(1, developer.getFirstName());
        statement.setString(2, developer.getLastName());
        statement.setLong(3, id);
        statement.executeUpdate();

        return Optional.of(developer);
    }

    @Override
    public Optional<Developer> getId(Long id) throws SQLException {
        Developer developer = null;
        PreparedStatement statement = dataSource.statement(GET_ID);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            developer = utilResultSet.onlyDeveloperById(resultSet, id);
        }
        return Optional.ofNullable(developer);
    }

    @Override
    public List<Developer> getAll() throws SQLException {
        List<Developer> developers = new ArrayList<>();
        PreparedStatement statement = dataSource.statement(GET_ALL_DEV);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            developers.add(utilResultSet.onlyDeveloper(resultSet));
        }
        return developers;
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        PreparedStatement statement = dataSource.statement(DELETE_DEV_ID);
        statement.setLong(1, id);
        statement.executeUpdate();
    }

//    private final ConfigDataSource configDataSource;
//    private Connection connection;
//    private static String GET_ALL_INFORMATION = """
//             select
//            d.id, d.firstName as First_Name,
//            d.lastName  as Last_Name,
//            sp.name as specialty,
//            sk.name as Skill
//            from developer d
//            join specialty sp on d.specialtyid = sp.id,
//                    skill sk,
//                    developer_skill ds
//                    where ds.developerid = d.id
//                    and ds.skillid = sk.id
//                    group by d.id, d.firstName, d.lastName, sp.name, sk.name
//                    ORDER BY id""";
//    private static String GET_DEVELOPER_AND_SPECIALTY = """
//            select d.id        ,
//                     d.firstName ,
//                     d.lastName  ,
//                     s.name
//              from developer d
//                       left join specialty s on s.id=d.specialtyid
//                       where  s.name=?
//                """;
//    private static String GET_DI = """
//            select
//                d.id,
//                d.firstname,
//                d.lastname,
//                s.name as skill,
//                sp.name as specialty
//            from developer d
//                join skill s on s.id=d.specialtyid, specialty sp, developer_skill ds where ds.developerid =d.id and ds.skillid=sp.id
//            group by d.id, d.firstname, d.lastname, s.name, sp.name having d.id=?
//            """;
//    public List<Developer> getDeveloperAndSpecialty(String name) throws SQLException {
//        List<Developer> developers = new ArrayList<>();
//        connection = configDataSource.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(GET_DEVELOPER_AND_SPECIALTY);
//
//        preparedStatement.setString(1, name);
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            developers.add(Developer.builder()
//                    .id(resultSet.getLong("id"))
//                    .firstName(resultSet.getString("firstName"))
//                    .lastName(resultSet.getString("lastName"))
//
//                    .specialty(new Specialty().toBuilder()
//                            .id(resultSet.getLong("id"))
//                            .name(resultSet.getString("name"))
//                            .build())
//                    .build());
//        }
//        return developers;
//
//    }
//    @Override
//    public List<Developer> getAll() throws SQLException {
//        List<Developer> developers = new ArrayList<>();
//        connection = configDataSource.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_INFORMATION);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            developers.add(Developer.builder()
//                    .id(resultSet.getLong("id"))
//                    .firstName(resultSet.getString("First_Name"))
//                    .lastName(resultSet.getString("Last_Name"))
//
//                    .specialty(new Specialty().toBuilder()
//                            .id(resultSet.getLong("id"))
//                            .name(resultSet.getString("specialty"))
//                            .build())
//
//                    .skills(List.of(new Skill().toBuilder()
//                            .id(resultSet.getLong("id"))
//                            .name(resultSet.getString("Skill"))
//                            .build()))
//
//                    .build());
//        }
//        return developers;
//    }
//    @Override
//    public Optional<Developer> save(Developer developer) throws SQLException {
//        connection = configDataSource.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("insert into developer(firstname, lastname) values (?,?)");
//        preparedStatement.setString(1, developer.getFirstName());
//        preparedStatement.setString(2, developer.getLastName());
//        preparedStatement.executeUpdate();
//        return Optional.of(developer);
//    }
//
//    public Optional<Developer> saveAll(Developer developer) throws SQLException {
//        connection = configDataSource.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("insert into developer(firstname, lastname) values (?,?)");
//        preparedStatement.setString(1, developer.getFirstName());
//        preparedStatement.setString(2, developer.getLastName());
//        preparedStatement.executeUpdate();
//        return Optional.of(developer);
//    }
//    @Override
//    public Optional<Developer> getId(Long id) throws SQLException {
//        Developer developer = null;
//        connection = configDataSource.getConnection();
//        PreparedStatement statement = connection.prepareStatement(GET_DI);
//        statement.setLong(1, id);
//
//        ResultSet resultSet = statement.executeQuery();
//        if (resultSet.next()) {
//            developer = Developer.builder()
//                    .id(id)
//                    .firstName(resultSet.getString("firstName"))
//                    .lastName(resultSet.getString("lastName"))
//
//                    .specialty(new Specialty()
//                            .toBuilder()
//                            .id(resultSet.getLong("id"))
//                            .name(resultSet.getString("skill"))
//                            .build())
//
//                    .skills(List.of(new Skill()
//                            .toBuilder()
//                            .id(resultSet.getLong("id"))
//                            .name(resultSet.getString("Skill"))
//                            .build()))
//                    .build();
//        }
//        assert developer != null;
//        return Optional.of(developer);
//    }
//    @Override
//    public Optional<Developer> update(Developer target) {
//
//        target = new Developer();
//
//        Specialty specialty = new Specialty();
//
//        Skill skill = new Skill();
//
//
//
//        return Optional.ofNullable(target);
//    }
//    @Override
//    public void deleteById(Long id) {

}

