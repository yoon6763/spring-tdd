package org.example.productorderservice.product;

import org.example.productorderservice.product.domain.DiscountPolicy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountPolicyTest {

    @Test
    void noneDiscountPolicy() {
        final int price = 1000;
        final int discountPrice = DiscountPolicy.NONE.applyDiscount(price);
        assertThat(discountPrice).isEqualTo(price);
    }

    @Test
    void fix1000AmountDiscountPolicy() {
        final int price = 2000;
        final int discountPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);
        assertThat(discountPrice).isEqualTo(1000);
    }
}