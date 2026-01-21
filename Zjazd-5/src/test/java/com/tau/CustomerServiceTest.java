package com.tau;

import com.tau.service.CustomerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    private final CustomerService service = new CustomerService();

    @Test
    void shouldReturnCustomers() {
        assertFalse(service.getAllCustomers().isEmpty());
    }

    @Test
    void shouldReturnCustomerById() {
        assertNotNull(service.getCustomerById("cus_001"));
    }
}
