package org.example.productorderservice.payment.application.service;

import org.springframework.util.Assert;

public record PaymentRequest(Long orderId, String cardNumber) {
    public PaymentRequest {
        Assert.notNull(orderId, "orderId must not be null");
        Assert.notNull(cardNumber, "cardNumber must not be null");
    }
}
