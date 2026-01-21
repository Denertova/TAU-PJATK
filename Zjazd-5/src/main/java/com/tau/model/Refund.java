package com.tau.model;

public class Refund {
    private final String id;
    private final String paymentId;
    private final int amount;
    private final String status;

    public Refund(String id, String paymentId, int amount, String status) {
        this.id = id;
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public int getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}
