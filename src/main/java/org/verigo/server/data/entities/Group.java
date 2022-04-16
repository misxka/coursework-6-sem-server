package org.verigo.server.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "groups")
@SequenceGenerator(name="GROUP_SEQ", sequenceName="group_sequence", initialValue = 1, allocationSize = 1)
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="GROUP_SEQ")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id", nullable = false)
    @JsonIgnoreProperties("groups")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="teacher_id", nullable = false)
    private User teacher;

    @ManyToMany
    @JoinTable(
        name = "user_group",
        joinColumns = @JoinColumn(name = "group_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
//    @JsonIgnoreProperties("groups")
    private List<User> participants = new ArrayList<>();

    public Group() {}

    public Group(String name) {
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public User getTeacher() {
        return teacher;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
}
