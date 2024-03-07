package org.example.productorderservice.order;

import org.example.productorderservice.product.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private final OrderPort orderPort;

    public OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void createOrder(CreateOrderRequest request) {
        final Product product = orderPort.getProductById(request.productId());
        final Order order = new Order(product, request.quantity());
        orderPort.save(order);
    }
}
