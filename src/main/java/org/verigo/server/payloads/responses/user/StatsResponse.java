package org.verigo.server.payloads.responses.user;

public class StatsResponse {
    private String role;

    private int amount;


    public StatsResponse(String role, int amount) {
        this.role = role;
        this.amount = amount;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
