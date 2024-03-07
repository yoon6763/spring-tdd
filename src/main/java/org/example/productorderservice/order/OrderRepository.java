package org.example.productorderservice.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
