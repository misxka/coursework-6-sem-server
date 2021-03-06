package org.verigo.server.payloads.responses;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Integer id;
    private String login;
    private String role;
    private String email;
    private String fullname;

    public JwtResponse(String accessToken, Integer id, String login, String email, String fullname, String role) {
        this.token = accessToken;
        this.id = id;
        this.login = login;
        this.role = role;
        this.email = email;
        this.fullname = fullname;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
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
