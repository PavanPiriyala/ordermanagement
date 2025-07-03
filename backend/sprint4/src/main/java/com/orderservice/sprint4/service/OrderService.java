package com.orderservice.sprint4.service;

import com.orderservice.sprint4.dto.OrderDetailsRequestDTO;
import com.orderservice.sprint4.dto.OrderDetailsResponseDTO;

public interface OrderService {
    String createOrderTransaction(OrderDetailsRequestDTO dto);
    OrderDetailsResponseDTO getOrderDetails(Integer orderId);
}
