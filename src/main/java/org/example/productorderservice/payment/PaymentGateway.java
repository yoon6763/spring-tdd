package org.example.productorderservice.payment;

import org.springframework.stereotype.Component;

@Component
public interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);
}
