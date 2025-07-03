package com.orderservice.sprint4.repository;

import com.orderservice.sprint4.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
