package org.verigo.server.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.*;

@Entity(name = "users")
@SequenceGenerator(name="USER_SEQ", sequenceName="user_sequence", initialValue = 1, allocationSize = 1)
public class User {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USER_SEQ")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String fullname;

    @Column(nullable = false)
    private String role;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATE")
    private Date createdAt;

    @ManyToMany
    @JoinTable(
        name = "user_course",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonIgnoreProperties("participants")
    private List<Course> courses = new ArrayList<>();

    public User() {}

    public User(String login, String password, String email, String fullname, String role, Date createdAt) {
        this.login = login;
        this.setPassword(password);
        this.email = email.toLowerCase();
        this.fullname = fullname;
        this.role = role;
        this.createdAt = createdAt;
    }

    public User(String login, String password, String email, String fullname, String role) {
        this.login = login;
        this.setPassword(password);
        this.email = email.toLowerCase();
        this.fullname = fullname;
        this.role = role;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String surname) {
        this.fullname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourses(Course course) {
        this.courses.add(course);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
            Objects.equals(login, user.login) &&
            Objects.equals(password, user.password) &&
            Objects.equals(email, user.email) &&
            Objects.equals(fullname, user.fullname) &&
            Objects.equals(createdAt, user.createdAt) &&
            Objects.equals(courses, user.courses) &&
            Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, fullname, role, courses, createdAt);
    }

    @Override
    public String toString() {
        return "";
    }
}
