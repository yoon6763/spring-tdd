package org.example.productorderservice.order;

import org.example.productorderservice.product.Product;

public interface OrderPort {

    Product getProductById(final Long productId);

    void save(Order order);

}
