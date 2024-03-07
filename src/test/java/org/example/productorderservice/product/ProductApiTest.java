package org.example.productorderservice.product;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.example.productorderservice.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class ProductApiTest extends ApiTest {

    private final ProductSteps productSteps = new ProductSteps();

    @Test
    void 상품등록() {
        final var request = productSteps.상품등록요청_생성();
        final var response = productSteps.상품등록요청(request);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    public ExtractableResponse<Response> 상품등록요청(AddProductRequest request) {
        return productSteps.상품등록요청(request);
    }


}
