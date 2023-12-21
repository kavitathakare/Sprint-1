package lk.spm.learning.management.mappers;

import lk.spm.learning.management.model.Class;
import lk.spm.learning.management.model.ImageModel;
import lk.spm.learning.management.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassMapper implements RowMapper<Class> {
    @Override
    public Class mapRow(ResultSet resultSet, int i) throws SQLException {
        Class class1 = new Class();
        class1.setId(resultSet.getLong("id"));
        class1.setDescription(resultSet.getString("description"));
        class1.setImage(resultSet.getString("image"));
        class1.setName(resultSet.getString("name"));
        class1.setTutorName(resultSet.getString("tutor_name"));
        return class1;
    }
}
