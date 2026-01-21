package com.tau.model;

public class Payment {
    private final String id;
    private final int amount;
    private final String currency;
    private final String status;
    private final String customerId;

    public Payment(String id, int amount, String currency, String status, String customerId) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.customerId = customerId;
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

    public String getCustomerId() {
        return customerId;
    }
}
