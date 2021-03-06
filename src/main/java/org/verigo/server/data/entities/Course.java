package org.verigo.server.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity(name = "courses")
@SequenceGenerator(name="COURSE_SEQ", sequenceName="course_sequence", initialValue = 1, allocationSize = 1)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="COURSE_SEQ")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private String level;

    @Column(name = "is_online", nullable = false)
    private boolean isOnline;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
    @JsonIgnoreProperties("course")
    private Set<Task> tasks = new HashSet<>();

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<User> participants = new ArrayList<>();

    public Course() {}

    public Course(String title, BigDecimal price, String language, String level, boolean isOnline) {
        this.title = title;
        this.price = price;
        this.language = language;
        this.level = level;
        this.isOnline = isOnline;
    }


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @JsonProperty(value = "isOnline")
    public boolean isOnline() {
        return isOnline;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public String getLanguage() {
        return language;
    }

    public String getLevel() {
        return level;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPrice(String price) {
        this.price = new BigDecimal(price);
    }

    public void setOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
            Objects.equals(title, course.title) &&
            Objects.equals(language, course.language) &&
            Objects.equals(isOnline, course.isOnline) &&
            Objects.equals(price, course.price) &&
            Objects.equals(tasks, course.tasks) &&
            Objects.equals(participants, course.participants) &&
            Objects.equals(level, course.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, language, isOnline, price, level, tasks, participants);
    }

    @Override
    public String toString() {
        return "";
    }
}
