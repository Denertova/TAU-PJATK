package com.tau;

import com.tau.service.RefundService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefundServiceTest {

    private final RefundService service = new RefundService();

    @Test
    void shouldReturnRefunds() {
        assertFalse(service.getAllRefunds().isEmpty());
    }

    @Test
    void shouldCreateRefund() {
        assertNotNull(service.createRefund("pay_001"));
    }
}
