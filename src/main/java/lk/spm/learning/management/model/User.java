package lk.spm.learning.management.model;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Users", uniqueConstraints=@UniqueConstraint(columnNames="username"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private String age;

    @NonNull
    @Column(name = "username")
    private String username;

    @Column(name = "status")
    private String status;

    @NonNull
    @Column(name = "password")
    private String password;

    @Column(name = "type")
    private String type;
    
    @Column(name = "year_of_enroll")
    private String year_of_enroll;
    
    @Column(name = "study_programm")
    @ElementCollection(targetClass=Course.class)
    private List<Course> study_programm;

    public void setStudyProgramm(List<Course> study_programm) {
        this.study_programm = study_programm;
    }
    
    public List<Course> getStudyProgramm() {
        return study_programm;
    }
    
    public void setYearOfEnroll(String year_of_enroll) {
        this.year_of_enroll = year_of_enroll;
    }
    
    public String getYearOfEnroll() {
        return year_of_enroll;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long userId) {
        this.id = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
