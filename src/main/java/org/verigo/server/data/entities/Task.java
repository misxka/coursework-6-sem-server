package org.verigo.server.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "tasks")
@SequenceGenerator(name="TASK_SEQ", sequenceName="task_sequence")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TASK_SEQ")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "is_hometask", nullable = false)
    private boolean isHometask;

    @Column(name = "max_points", nullable = false)
    private int maxPoints;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id", nullable = false)
    private Course course;

    public Task() {}

    public Task(String title, String description, boolean isHometask, int maxPoints) {
        this.title = title;
        this.description = description;
        this.isHometask = isHometask;
        this.maxPoints = maxPoints;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @JsonProperty(value = "isHometask")
    public boolean isHometask() {
        return isHometask;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public Course getCourse() {
        return course;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsHometask(boolean isHometask) {
        this.isHometask = isHometask;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
            Objects.equals(title, task.title) &&
            Objects.equals(description, task.description) &&
            Objects.equals(isHometask, task.isHometask) &&
            Objects.equals(maxPoints, task.maxPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, isHometask, maxPoints);
    }

    @Override
    public String toString() {
        return "Task{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", isHometask='" + isHometask + '\'' +
            ", maxPoints='" + maxPoints + '\'' +
            '}';
    }
}