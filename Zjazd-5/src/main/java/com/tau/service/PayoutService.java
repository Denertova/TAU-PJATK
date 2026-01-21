package com.tau.service;

import com.tau.data.MockData;
import com.tau.model.Payout;

import java.util.List;

public class PayoutService {

    // GET /payouts
    public List<Payout> getAllPayouts() {
        return MockData.PAYOUTS;
    }
}
