package org.verigo.server.payloads.responses.user;

import org.verigo.server.data.entities.User;

public class UpdateResponse {
    private String message;

    private Integer status;

    private UserDTO user;

    private Integer id;

    public UpdateResponse(Integer id, UserDTO user, Integer status, String message) {
        this.id = id;
        this.user = user;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
