package org.example.productorderservice.payment.application.port;

import org.example.productorderservice.order.domain.Order;
import org.example.productorderservice.payment.domain.Payment;

public interface PaymentPort {
    Order getOrder(Long orderId);

    void save(Payment payment);

    void pay(int price, String cardNumber);
}
