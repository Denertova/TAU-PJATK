package com.tau.service;

import com.tau.data.MockData;
import com.tau.model.Refund;

import java.util.List;

public class RefundService {

    // GET /refunds
    public List<Refund> getAllRefunds() {
        return MockData.REFUNDS;
    }

    // POST /refunds
    public Refund createRefund(String paymentId) {
        return new Refund("ref_002", paymentId, 1000, "completed");
    }
}
