package org.example.productorderservice.payment.adapter;

import org.springframework.stereotype.Component;

@Component
public interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);
}
