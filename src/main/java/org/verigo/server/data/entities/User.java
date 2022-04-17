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

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String role;

    @ManyToMany(mappedBy = "participants")
    @JsonIgnoreProperties("participants")
    private List<Group> groups = new ArrayList<>();

    public User() {}

    public User(String login, String password, String surname, String name, String role) {
        this.login = login;
        this.setPassword(password);
        this.surname = surname;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
            Objects.equals(surname, user.surname) &&
            Objects.equals(name, user.name) &&
            Objects.equals(groups, user.groups) &&
            Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, surname, name, role, groups);
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", login='" + login + '\'' +
            ", surname='" + surname + '\'' +
            ", name='" + name + '\'' +
            ", role='" + role + '\'' +
            ", groups='" + groups + '\'' +
            '}';
    }
}
