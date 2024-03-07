package org.example.productorderservice.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Getter
@Table(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private DiscountPolicy discountPolicy;

    public Product(String name, int price, DiscountPolicy discountPolicy) {
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void update(String name, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(name, "name must not be empty");
        Assert.isTrue(price > 0, "price must be greater than 0");
        Assert.notNull(discountPolicy, "discountPolicy must not be null");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }
}
