package org.example.productorderservice.payment;

import org.assertj.core.api.Assertions;
import org.example.productorderservice.product.DiscountPolicy;
import org.example.productorderservice.product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentServiceTest {

    private PaymentService paymentService;
    private PaymentPort paymentPort;

    @BeforeEach
    void setUp() {
        final PaymentGateway paymentGateway = new ConsolePaymentGateway();
        final PaymentRepository paymentRepository = new PaymentRepository();

        paymentPort = new PaymentAdapter(paymentGateway, paymentRepository);
        paymentService = new PaymentService(paymentPort);
    }

    @Test
    void 상품주문() {
        final PaymentRequest request = PaymentSteps.주문결제요청_생성();
        paymentService.payment(request);
    }

    @Test
    void update() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        product.update("상품 수정", 2000, DiscountPolicy.NONE);
        assertThat(product.getName()).isEqualTo("상품 수정");
        assertThat(product.getPrice()).isEqualTo(2000);
    }

    @Test
    void none_discounted_product() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        final int discountedPrice = product.getDiscountPrice();
        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void fix_1000_discounted_product() {
        final Product product = new Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT);
        final int discountedPrice = product.getDiscountPrice();
        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void over_discounted_product() {
        final Product product = new Product("상품명", 500, DiscountPolicy.FIX_1000_AMOUNT);
        final int discountedPrice = product.getDiscountPrice();
        assertThat(discountedPrice).isEqualTo(0);
    }

}
