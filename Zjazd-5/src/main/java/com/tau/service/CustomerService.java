package com.tau.service;

import com.tau.data.MockData;
import com.tau.model.Customer;

import java.util.List;

public class CustomerService {

    // GET /customers
    public List<Customer> getAllCustomers() {
        return MockData.CUSTOMERS;
    }

    // GET /customers/{id}
    public Customer getCustomerById(String id) {
        return MockData.CUSTOMERS.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
