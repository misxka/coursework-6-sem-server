package org.verigo.server.payloads.responses.course;

import org.verigo.server.data.entities.Course;

public class UpdateResponse {
    private String message;

    private Integer status;

    private Course course;

    private Integer id;

    public UpdateResponse(Integer id, Course course, Integer status, String message) {
        this.id = id;
        this.course = course;
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
