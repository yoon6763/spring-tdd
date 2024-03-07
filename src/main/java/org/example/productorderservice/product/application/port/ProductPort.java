package org.example.productorderservice.product.application.port;

import org.example.productorderservice.product.domain.Product;

public interface ProductPort {
    void save(Product product);

    Product getProduct(Long productId);
}
