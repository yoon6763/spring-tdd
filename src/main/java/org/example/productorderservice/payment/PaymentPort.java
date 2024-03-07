package org.example.productorderservice.payment;

import org.example.productorderservice.order.Order;

public interface PaymentPort {
    Order getOrder(Long orderId);

    void save(Payment payment);

    void pay(int price, String cardNumber);
}
