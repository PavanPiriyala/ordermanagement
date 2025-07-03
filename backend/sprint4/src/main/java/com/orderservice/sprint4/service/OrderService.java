package com.orderservice.sprint4.service;


import com.orderservice.sprint4.dto.OrderResponseDTO;

import java.util.List;

public interface OrderService {
    List<OrderResponseDTO> getOrdersByRange(String range);
}

