package org.example.productorderservice.product.adapter;

import org.example.productorderservice.product.application.port.ProductPort;
import org.example.productorderservice.product.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductAdapter implements ProductPort {
    private final ProductRepository productRepository;

    ProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }
}
