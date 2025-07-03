package com.orderservice.sprint4.repository;

import com.orderservice.sprint4.model.OrderInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInvoiceRepository extends JpaRepository<OrderInvoice,Integer> {
}