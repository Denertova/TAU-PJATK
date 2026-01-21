package com.tau.data;

import com.tau.model.*;
import java.util.List;

public class MockData {

    public static final List<Customer> CUSTOMERS = List.of(
            new Customer("cus_001", "jan.kowalski@example.com", "Jan Kowalski")
    );

    public static final List<Payment> PAYMENTS = List.of(
            new Payment("pay_001", 1999, "PLN", "succeeded", "cus_001")
    );

    public static final List<Refund> REFUNDS = List.of(
            new Refund("ref_001", "pay_001", 1999, "completed")
    );

    public static final List<Payout> PAYOUTS = List.of(
            new Payout("po_001", 150000, "PLN", "pending")
    );
}
