package org.example.productorderservice;

import org.example.productorderservice.product.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void 상품등록() {
        final AddProductRequest request = 상품등록요청_생성();
        productService.addProduct(request);
    }

    private static AddProductRequest 상품등록요청_생성() {
        return new AddProductRequest("상품명", 1000, DiscountPolicy.NONE);
    }

}