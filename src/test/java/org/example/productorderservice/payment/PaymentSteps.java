package org.example.productorderservice.payment;

import org.example.productorderservice.payment.PaymentRequest;

public class PaymentSteps {
    public static PaymentRequest 주문결제요청_생성() {
        final String cardNumber = "1234-1234-1234-1234";
        final Long orderId = 1L;
        return new PaymentRequest(orderId, cardNumber);
    }
}
