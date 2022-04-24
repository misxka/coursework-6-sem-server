package org.verigo.server.payloads.responses.card;

import org.verigo.server.data.entities.Card;

public class CreateResponse {
    private String message;

    private Integer status;

    private Card card;

    public CreateResponse(Card card, Integer status, String message) {
        this.card = card;
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
