package org.verigo.server.payloads.responses.card;

import org.verigo.server.data.entities.Card;

public class UpdateResponse {
    private Integer id;

    private String message;

    private Integer status;

    private Card card;

    public UpdateResponse(Integer id, Card card, Integer status, String message) {
        this.id = id;
        this.card = card;
        this.status = status;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
