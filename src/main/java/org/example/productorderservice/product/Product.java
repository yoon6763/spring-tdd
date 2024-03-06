package org.example.productorderservice.product;

import lombok.Getter;

@Getter
public class Product {

    private Long id;
    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;

    public Product(String name, int price, DiscountPolicy discountPolicy) {
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void assignId(Long id) {
        this.id = id;
    }

}
