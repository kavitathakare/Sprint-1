package lk.spm.learning.management.mappers;

import lk.spm.learning.management.model.Course;
import lk.spm.learning.management.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonMapper implements RowMapper<User> {
    @SuppressWarnings("unchecked")
	@Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User person = new User();
        person.setId(resultSet.getLong("id"));
        person.setEmail(resultSet.getString("email"));
        person.setAge(resultSet.getString("age"));
        person.setName(resultSet.getString("name"));
        person.setPassword(resultSet.getString("password"));
        person.setUsername(resultSet.getString("username"));
        person.setStatus(resultSet.getString("status"));
        person.setType(resultSet.getString("type"));
        person.setYearOfEnroll(resultSet.getString("year_of_enroll"));
        person.setStudyProgramm((List<Course>) resultSet.getArray("study_programm"));
        return person;
    }
}
