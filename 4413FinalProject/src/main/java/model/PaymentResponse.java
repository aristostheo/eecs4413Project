package model;

import java.io.Serializable;

public class PaymentResponse implements Serializable{
    private String message;
    private double amount;
    private int orderId; // Add this field

    // Constructor for successful payment
    public PaymentResponse(String message, double amount, int orderId) {
        this.message = message;
        this.amount = amount;
        this.orderId = orderId;
    }

    // Constructor for failed payment
    public PaymentResponse(String message, double amount) {
        this.message = message;
        this.amount = amount;
        this.orderId = -1; // Default value indicating no valid order ID
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
