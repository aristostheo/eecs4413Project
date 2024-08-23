package model;


public class PaymentService {
    private int requestCount = 0;

    public boolean processPayment(String cardNumber, double amount) {
        requestCount++;
        // Deny every 3rd request as a dummy algorithm
        return requestCount % 3 != 0;
    }
}
