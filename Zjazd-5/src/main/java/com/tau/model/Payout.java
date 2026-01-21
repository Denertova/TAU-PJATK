package com.tau.model;

public class Payout {
    private final String id;
    private final int amount;
    private final String currency;
    private final String status;

    public Payout(String id, int amount, String currency, String status) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStatus() {
        return status;
    }
}

