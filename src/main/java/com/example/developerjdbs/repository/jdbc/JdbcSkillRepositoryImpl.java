package com.example.developerjdbs.repository.jdbc;

import com.example.developerjdbs.config.ConfigDataSource;
import com.example.developerjdbs.model.Skill;
import com.example.developerjdbs.repository.SkillRepository;
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
public class JdbcSkillRepositoryImpl implements SkillRepository {

    private final UtilResultSet utilResultSet;
    private final static String GET_ALL_SILLS = "select id, name as SKILL from skill";
    private final static String SAVE_SKELL = "insert into skill(name)values (?)";
    private final static String GET_ID = "select * from skill where id=?";
    private final static String DELETE_SKILL_ID = "delete from skill where id=?";
    private final static String UPDATE_SKILL = "update  skill set name=? where id=?";

    @Override
    public Optional<Skill> save(Skill skill) {
        try (PreparedStatement statement = ConfigDataSource.statement(SAVE_SKELL)) {
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
        try (PreparedStatement statement = ConfigDataSource.statement(GET_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                skill = utilResultSet.onlySkillById(resultSet, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(skill);
    }
    @Override
    public List<Skill> getAll() {
        List<Skill> skills = new ArrayList<>();
        try (PreparedStatement statement = ConfigDataSource.statement(GET_ALL_SILLS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                skills.add(utilResultSet.onlySkill(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skills;
    }
    @Override
    public void deleteById(Long id) {
        try (PreparedStatement statement = ConfigDataSource.statement(DELETE_SKILL_ID)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Optional<Skill> update(Skill skill, Long id) {
        try (PreparedStatement statement = ConfigDataSource.statement(UPDATE_SKILL)) {
            statement.setString(1, skill.getName());
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(skill);
    }
}
