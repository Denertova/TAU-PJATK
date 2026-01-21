package com.tau.model;

public class Customer {
    private final String id;
    private final String email;
    private final String name;

    public Customer(String id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
