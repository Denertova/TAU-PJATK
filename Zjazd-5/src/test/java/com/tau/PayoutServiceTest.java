package com.tau;

import com.tau.service.PayoutService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayoutServiceTest {

    private final PayoutService service = new PayoutService();

    @Test
    void shouldReturnPayouts() {
        assertFalse(service.getAllPayouts().isEmpty());
    }
}
