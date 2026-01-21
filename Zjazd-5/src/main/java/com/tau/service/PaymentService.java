package com.tau.service;

import com.tau.data.MockData;
import com.tau.model.Payment;


import java.util.List;


public class PaymentService {


    // GET /payments
    public List<Payment> getAllPayments() {
        return MockData.PAYMENTS;
    }


    // GET /payments/{id}
    public Payment getPaymentById(String id) {
        return MockData.PAYMENTS.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // POST /payments
    public Payment createPayment() {
        return new Payment("pay_002", 5000, "PLN", "succeeded", "cus_001");
    }
}
