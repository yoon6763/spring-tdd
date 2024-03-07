package org.example.productorderservice.product;

import org.springframework.util.Assert;

public record GetProductResponse(
        long id,
        String name,
        int price,
        DiscountPolicy discountPolicy
) {
    public GetProductResponse(long id, String name, int price, DiscountPolicy discountPolicy) {
        Assert.notNull(id, "id must not be null");
        Assert.hasText(name, "name must not be empty");
        Assert.notNull(discountPolicy, "discountPolicy must not be null");
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }
}
