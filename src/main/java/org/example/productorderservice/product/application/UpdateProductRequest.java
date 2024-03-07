package org.example.productorderservice.product.application;

import org.example.productorderservice.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

public record UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {

    public UpdateProductRequest {
        Assert.hasText(name, "name must not be empty");
        Assert.isTrue(price > 0, "price must be greater than 0");
        Assert.notNull(discountPolicy, "discountPolicy must not be null");
    }
}
