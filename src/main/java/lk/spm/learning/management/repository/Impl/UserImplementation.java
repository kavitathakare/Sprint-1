package lk.spm.learning.management.repository.Impl;
import lk.spm.learning.management.model.*;
import lk.spm.learning.management.mappers.PersonMapper;
import lk.spm.learning.management.repository.loginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserImplementation implements loginUserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String validateUser(User user) {
        String sql = "SELECT type FROM users WHERE username=? AND password=?";
        try {
            String type = jdbcTemplate.queryForObject(sql, new Object[] {
                    user.getUsername(), user.getPassword() }, String.class);
            return type;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> getStudentList() {
        String sql = "SELECT * FROM users WHERE type = 'student' order by id";
        List<User> users = jdbcTemplate.query(sql, new PersonMapper());
        System.out.println(users);
        return users;
    }

    @Override
    public List<User> getTeacherList() {
        String sql = "SELECT * FROM users WHERE type = 'teacher' order by id";
        List<User> users = jdbcTemplate.query(sql, new PersonMapper());
        System.out.println(users);
        return users;
    }


    @Override
    public List<User> getValidTeacherList() {
        String sql = "SELECT * FROM users WHERE type = 'teacher' and status = 'valid' order by id";
        List<User> users = jdbcTemplate.query(sql, new PersonMapper());
        System.out.println(users);
        return users;
    }

    @Override
    public List<User> getInvalidTeacherList() {
        String sql = "SELECT * FROM users WHERE type = 'teacher' and status = 'invalid' order by id";
        List<User> users = jdbcTemplate.query(sql, new PersonMapper());
        System.out.println(users);
        return users;
    }

    @Override
    public List<User> getPendingTeacherList() {
        String sql = "SELECT * FROM users WHERE type = 'teacher' and status = 'pending' order by id";
        List<User> users = jdbcTemplate.query(sql, new PersonMapper());
        System.out.println(users);
        return users;
    }

    @Override
    public List<User> getUserList() {
        String sql = "SELECT * FROM users order by id";
        List<User> users = jdbcTemplate.query(sql, new PersonMapper());
        System.out.println(users);
        return users;
    }

    @Override
    public String getTeacherStatus(User user) {
        String sql = "SELECT status FROM users WHERE username=? AND password=?";
        try {
            String status = jdbcTemplate.queryForObject(sql, new Object[] {
                    user.getUsername(), user.getPassword() }, String.class);
            return status;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getUserID(User user) {
        String sql = "SELECT id FROM users WHERE username=? AND password=?";
        try {
            String id = jdbcTemplate.queryForObject(sql, new Object[] {
                    user.getUsername(), user.getPassword() }, String.class);
            return id;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getUserByName(loginUser user) {
        String sql = "SELECT id FROM users WHERE username=? AND password=?";
        try {
            String userId = jdbcTemplate.queryForObject(sql, new Object[] {
                    user.getUsername(), user.getPassword() }, String.class);
            return userId;
        } catch (Exception e) {
            return null;
        }
    }

	@Override
	public List<Class> getClassList() {
		// TODO Auto-generated method stub
		return null;
	}
}
