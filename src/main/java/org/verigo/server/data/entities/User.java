//package org.verigo.server.entities;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Objects;
//
//@Entity(name = "users")
//public class User {
//    private @Id @GeneratedValue Integer id;
//    private String login;
//    private String password;
//    private String surname;
//    private String name;
//
//    @CreatedDate
//    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "DATETIME(0)")
//    private Date createdAt;
//
//    @LastModifiedDate
//    @Column(name = "updated_at", columnDefinition = "DATETIME(0)")
//    private Date updatedAt;
//
//    @ManyToOne
//    @JoinColumn(name = "role_id", nullable = false)
//    private Role role;
//
//    @ManyToMany(mappedBy = "participants")
//    @JsonIgnoreProperties("participants")
//    private List<CourseGroup> groups = new ArrayList<>();
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonManagedReference(value = "user-results")
//    private List<UserTaskResult> tasksResults = new ArrayList<>();
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(id, user.id) &&
//                Objects.equals(login, user.login) &&
//                Objects.equals(password, user.password) &&
//                Objects.equals(surname, user.surname) &&
//                Objects.equals(name, user.name) &&
//                Objects.equals(createdAt, user.createdAt) &&
//                Objects.equals(updatedAt, user.updatedAt) &&
//                Objects.equals(role, user.role) &&
//                Objects.equals(groups, user.groups) &&
//                Objects.equals(tasksResults, user.tasksResults);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, login, password, surname, name, createdAt, updatedAt, role, groups, tasksResults);
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Date getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(Date updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public List<CourseGroup> getGroups() {
//        return groups;
//    }
//
//    public void setGroups(List<CourseGroup> groups) {
//        this.groups = groups;
//    }
//
//    public List<UserTaskResult> getTasksResults() {
//        return tasksResults;
//    }
//
//    public void setTasksResults(List<UserTaskResult> tasksResults) {
//        this.tasksResults = tasksResults;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//            "id=" + id +
//            ", firstName='" + login + '\'' +
//            ", lastName='" + lastName + '\'' +
//            ", description='" + description + '\'' +
//            '}';
//    }
//}
