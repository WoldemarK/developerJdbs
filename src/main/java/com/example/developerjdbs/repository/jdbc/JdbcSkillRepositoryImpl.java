package com.example.developerjdbs.repository.jdbc;

import com.example.developerjdbs.model.Skill;
import com.example.developerjdbs.repository.SkillRepository;
import lombok.RequiredArgsConstructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.developerjdbs.config.ConfigDataSource.statement;
import static com.example.developerjdbs.util.UtilResultSet.onlySkill;
import static com.example.developerjdbs.util.UtilResultSet.onlySkillById;

@RequiredArgsConstructor
public class JdbcSkillRepositoryImpl implements SkillRepository {
    private final static String GET_ALL_SILLS = "select id, name as SKILL from skill";
    private final static String SAVE_SKELL = "insert into skill(name)values (?)";
    private final static String GET_ID = "select name from skill where id=?";
    private final static String DELETE_SKILL_ID = "delete from skill where id=?";
    private final static String UPDATE_SKILL = "update  skill set name=? where id=?";
    @Override

    public Optional<Skill> save(Skill skill) {
        try (PreparedStatement statement = statement(SAVE_SKELL)) {
            statement.setString(1, skill.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(skill);
    }
    @Override
    public Optional<Skill> getId(Long id) {
        Skill skill = null;
        try (PreparedStatement statement = statement(GET_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                skill = onlySkillById(resultSet, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(skill);
    }
    @Override
    public List<Skill> getAll() {
        List<Skill> skills = new ArrayList<>();
        try (PreparedStatement statement = statement(GET_ALL_SILLS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                skills.add(onlySkill(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skills;
    }
    @Override
    public void deleteById(Long id) {
        try (PreparedStatement statement = statement(DELETE_SKILL_ID)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Optional<Skill> update(Skill skill, Long id) {
        try (PreparedStatement statement = statement(UPDATE_SKILL)) {
            statement.setString(1, skill.getName());
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(skill);
    }
}
