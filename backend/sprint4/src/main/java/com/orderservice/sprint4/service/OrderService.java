package com.orderservice.sprint4.service;

import com.orderservice.sprint4.dto.OrderSummaryDTO;
import com.orderservice.sprint4.dto.OrderDetailsRequestDTO;
import com.orderservice.sprint4.dto.OrderDetailsResponseDTO;

public interface OrderService {
    String createOrderTransaction(OrderDetailsRequestDTO dto);
    OrderDetailsResponseDTO getOrderDetails(Integer orderId);
    List<OrderSummaryDTO> getOrderHistoryByMonths(int months);
}
