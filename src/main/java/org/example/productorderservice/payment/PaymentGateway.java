package org.example.productorderservice.payment;

public interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);
}
