package org.verigo.server.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "users")
@SequenceGenerator(name="USER_SEQ", sequenceName="user_sequence", initialValue = 1, allocationSize = 1)
public class User {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USER_SEQ")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String login;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String fullname;

    @Column(nullable = false)
    private String role;

    @ManyToMany(mappedBy = "participants")
    @JsonIgnoreProperties("participants")
    private List<Group> groups = new ArrayList<>();

    public User() {}

    public User(String login, String password, String email, String fullname, String role) {
        this.login = login;
        this.setPassword(password);
        this.email = email.toLowerCase();
        this.fullname = fullname;
        this.role = role;
    }

//    @ManyToOne
//    @JoinColumn(name = "role_id", nullable = false)
//    private Role role;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonManagedReference(value = "user-results")
//    private List<UserTaskResult> tasksResults = new ArrayList<>();


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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
//
//    public List<UserTaskResult> getTasksResults() {
//        return tasksResults;
//    }
//
//    public void setTasksResults(List<UserTaskResult> tasksResults) {
//        this.tasksResults = tasksResults;
//    }


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
            Objects.equals(groups, user.groups) &&
            Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, fullname, role, groups);
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", login='" + login + '\'' +
            ", email='" + email + '\'' +
            ", fullname='" + fullname + '\'' +
            ", role='" + role + '\'' +
            ", groups='" + groups + '\'' +
            '}';
    }
}
