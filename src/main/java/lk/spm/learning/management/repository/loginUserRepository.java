package lk.spm.learning.management.repository;

import lk.spm.learning.management.model.Class;
import lk.spm.learning.management.model.User;
import lk.spm.learning.management.model.loginUser;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface loginUserRepository {
    String validateUser (@RequestBody User user);
//    List<User>  getStudentList();//User
    List<User> getStudentList();
    List<User> getTeacherList();
    List<User> getUserList();
    List<Class> getClassList();
    List<User> getValidTeacherList();
    List<User> getInvalidTeacherList();
    List<User> getPendingTeacherList();
//    List<ImageModel> getTutorListFromClasses();
    String getTeacherStatus(@RequestBody User user);
    String getUserID(@RequestBody User user);

    String getUserByName(loginUser user);
}
