package model;

import java.io.Serializable;

public class PaymentService implements Serializable{
    private int requestCount = 0;
    private static final long serialVersionUID = 1L;

    public boolean processPayment(String cardNumber, double amount) {
        requestCount++;
        // Deny every 3rd request as a dummy algorithm
        return requestCount % 3 != 0;
    }
}
