package org.example.productorderservice.order;

import org.example.productorderservice.product.DiscountPolicy;
import org.example.productorderservice.product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private OrderService orderService;
    private OrderPort orderPort;

    @BeforeEach
    void setUp() {
        final OrderRepository orderRepository = new OrderRepository();
        orderPort = new OrderPort() {
            @Override
            public Product getProductById(Long productId) {
                return new Product("상품명", 1000, DiscountPolicy.NONE);
            }

            @Override
            public void save(Order order) {
                orderRepository.save(order);
            }
        };
        orderService = new OrderService(orderPort);
    }

    @Test
    void 상품주문() {
        final Long productId = 1L;
        final int quantity = 2;

        final CreateOrderRequest request = new CreateOrderRequest(productId, quantity);
        orderService.createOrder(request);
    }
}
