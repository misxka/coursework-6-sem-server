package org.verigo.server.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_hometask")
    private boolean isHometask;

    @Column(name = "max_points")
    private int maxPoints;

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