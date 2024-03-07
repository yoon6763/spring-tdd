package org.example.productorderservice.payment;

import org.example.productorderservice.ApiTest;
import org.example.productorderservice.order.application.service.OrderService;
import org.example.productorderservice.order.OrderSteps;
import org.example.productorderservice.payment.application.service.PaymentService;
import org.example.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentApiTest extends ApiTest {

    private OrderService orderService;
    private PaymentService paymentService;

    @Test
    void 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성());
        final var request = PaymentSteps.주문결제요청_생성();
        final var response = PaymentSteps.주문결제요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
