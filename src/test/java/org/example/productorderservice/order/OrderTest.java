package org.example.productorderservice.order;

import org.example.productorderservice.order.domain.Order;
import org.example.productorderservice.product.domain.DiscountPolicy;
import org.example.productorderservice.product.domain.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Test
    void getTotalPrice() {
        final Order order = new Order(new Product("상품명", 1000, DiscountPolicy.NONE), 2);
        final int totalPrice = order.getTotalPrice();
        assertThat(totalPrice).isEqualTo(2000);
    }
}