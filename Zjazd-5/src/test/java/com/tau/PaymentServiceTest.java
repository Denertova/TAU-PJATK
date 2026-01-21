package com.tau;

import com.tau.service.PaymentService;
import com.tau.model.Payment;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class PaymentServiceTest {


    private final PaymentService service = new PaymentService();


    @Test
    void shouldReturnAllPayments() {
        assertFalse(service.getAllPayments().isEmpty());
    }

    @Test
    void shouldReturnPaymentById() {
        Payment payment = service.getPaymentById("pay_001");
        assertNotNull(payment);
        assertEquals("pay_001", payment.getId());
    }

    @Test
    void shouldCreatePayment() {
        Payment payment = service.createPayment();
        assertEquals("succeeded", payment.getStatus());
    }
}