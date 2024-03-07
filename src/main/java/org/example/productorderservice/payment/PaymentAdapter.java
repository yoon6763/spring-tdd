package org.example.productorderservice.payment;

import org.example.productorderservice.order.Order;
import org.example.productorderservice.order.OrderRepository;
import org.example.productorderservice.product.DiscountPolicy;
import org.example.productorderservice.product.Product;
import org.springframework.stereotype.Component;

import java.util.concurrent.ForkJoinPool;

@Component
public class PaymentAdapter implements PaymentPort {

    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("주문을 찾을 수 없습니다."));
    }

    @Override
    public void pay(int totalPrice, String cardNumber) {
        paymentGateway.execute(totalPrice, cardNumber);
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }
}
