package org.example.productorderservice.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
    private final Map<Long, Order> persistence = new HashMap<>();
    private Long sequence = 0L;

    public void save(Order order) {
        order.assignId(++sequence);
        persistence.put(order.getId(), order);
    }

}
