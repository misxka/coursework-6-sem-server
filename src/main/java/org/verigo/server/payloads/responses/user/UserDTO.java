package org.verigo.server.payloads.responses.user;

import org.verigo.server.data.entities.User;

public class UserDTO {
    private Integer id;

    private String login;

    private String fullname;

    private String role;

    private String email;


    public UserDTO(User user) {
        this.email = user.getEmail();
        this.fullname = user.getFullname();
        this.id = user.getId();
        this.role = user.getLogin();
        this.login = user.getLogin();
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
