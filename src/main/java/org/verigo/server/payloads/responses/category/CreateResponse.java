package org.verigo.server.payloads.responses.category;

import org.verigo.server.data.entities.Category;

public class CreateResponse {
    private String message;

    private Integer status;

    private Category category;

    public CreateResponse(Category category, Integer status, String message) {
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
