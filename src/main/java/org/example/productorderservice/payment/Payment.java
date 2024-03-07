package org.example.productorderservice.payment;

import lombok.Getter;
import org.example.productorderservice.order.Order;
import org.springframework.util.Assert;

@Getter
public class Payment {
    private Long id;
    private final Order order;
    private final String cardNumber;

    public Payment(Order order, String cardNumber) {
        Assert.notNull(order, "order must not be null");
        Assert.notNull(cardNumber, "cardNumber must not be null");
        this.order = order;
        this.cardNumber = cardNumber;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }
}
