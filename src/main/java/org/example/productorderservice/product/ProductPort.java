package org.example.productorderservice.product;

public interface ProductPort {
    void save(Product product);

    Product getProduct(Long productId);
}
