package model;

import java.io.Serializable;

public class PaymentRequest implements Serializable {
    private static final long serialVersionUID = 1L;
	private String cardNumber;
    private double amount;

    // Getters and Setters
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
