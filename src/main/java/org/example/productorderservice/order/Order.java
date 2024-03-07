package org.example.productorderservice.order;

import org.example.productorderservice.product.Product;
import org.springframework.util.Assert;

public class Order {

    private Long id;
    private final Product product;
    private final int quantity;

    public Order(Product product, int quantity) {
        Assert.notNull(product, "product must not be null");
        Assert.isTrue(quantity > 0, "quantity must be greater than 0");
        this.product = product;
        this.quantity = quantity;
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
