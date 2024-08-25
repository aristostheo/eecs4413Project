package model;

import java.io.Serializable;

public class PaymentResponse implements Serializable{
    private String message;
    private double amount;

    // Constructor
    public PaymentResponse(String message, double amount) {
        this.message = message;
        this.amount = amount;
    }

    // Getters and Setters
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
}
