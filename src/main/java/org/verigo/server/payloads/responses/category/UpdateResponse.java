package org.verigo.server.payloads.responses.category;

public class UpdateResponse {
    private String message;

    private Integer status;

    private String name;

    private Integer id;

    public UpdateResponse(Integer id, String name, Integer status, String message) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
