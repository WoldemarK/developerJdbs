package com.example.developer.repository.jdbc;

import com.example.developer.config.ConfigDataSource;
import com.example.developer.model.Skill;
import com.example.developer.repository.SkillRepository;
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
public class JdbcSkillRepositoryImpl implements SkillRepository {

    private final ConfigDataSource dataSource;
    private final UtilResultSet utilResultSet;
    private final static String GET_ALL_SILLS = "select id, name as SKILL from skill";
    private final static String SAVE_SKELL = "insert into skill(name)values (?)";
    private final static String GET_ID = "select * from skill where id=?";
    private final static String DELETE_SKILL_ID = "delete from skill where id=?";
    private final static String UPDATE_SKILL = "update  skill set name=? where id=?";
    @Override
    public Optional<Skill> save(Skill skill) throws SQLException {
        PreparedStatement statement = dataSource.statement(SAVE_SKELL);
        statement.setString(1, skill.getName());
        statement.executeUpdate();
        return Optional.of(skill);

    }
    @Override
    public Optional<Skill> getId(Long id) throws SQLException {
        Skill skill = null;
        PreparedStatement statement = dataSource.statement(GET_ID);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            skill = utilResultSet.onlySkillById(resultSet, id);
        }
        return Optional.ofNullable(skill);
    }
    @Override
    public List<Skill> getAll() throws SQLException {
        List<Skill> skills = new ArrayList<>();
        PreparedStatement statement = dataSource.statement(GET_ALL_SILLS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            skills.add(utilResultSet.onlySkill(resultSet));
        }
        return skills;
    }
    @Override
    public void deleteById(Long id) throws SQLException {
        PreparedStatement statement = dataSource.statement(DELETE_SKILL_ID);
        statement.setLong(1, id);
        statement.executeUpdate();
    }
    @Override
    public Optional<Skill> update(Skill skill, Long id) throws SQLException {
        PreparedStatement statement = dataSource.statement(UPDATE_SKILL);
        statement.setString(1, skill.getName());
        statement.setLong(2, id);
        statement.executeUpdate();
        return Optional.of(skill);
    }


}