package org.verigo.server.payloads.responses;

public class UserInfoResponse {
    private Integer id;
    private String login;
    private String role;
    private String email;
    private String fullname;

    public UserInfoResponse(Integer id, String login, String email, String fullname, String role) {
        this.id = id;
        this.login = login;
        this.role = role;
        this.email = email;
        this.fullname = fullname;
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

    public String getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }
}
