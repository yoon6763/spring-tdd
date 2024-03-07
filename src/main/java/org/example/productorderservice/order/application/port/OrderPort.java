package org.example.productorderservice.order.application.port;

import org.example.productorderservice.order.domain.Order;
import org.example.productorderservice.product.domain.Product;

public interface OrderPort {

    Product getProductById(final Long productId);

    void save(Order order);

}
