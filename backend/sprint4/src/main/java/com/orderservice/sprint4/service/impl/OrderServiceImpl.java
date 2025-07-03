package com.orderservice.sprint4.service.impl;


import com.orderservice.sprint4.dto.OrderResponseDTO;
import com.orderservice.sprint4.repository.OrderRepository;
import com.orderservice.sprint4.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderResponseDTO> getOrdersByRange(String range) {
        LocalDateTime fromDate;

        switch (range) {
            case "1week":
                fromDate = LocalDateTime.now().minusWeeks(1);
                break;
            case "1month":
                fromDate = LocalDateTime.now().minusMonths(1);
                break;
            case "6months":
                fromDate = LocalDateTime.now().minusMonths(6);
                break;
            case "1year":
                fromDate = LocalDateTime.now().minusYears(1);
                break;
            case "all":
            default:
                return orderRepository.findAll().stream().map(OrderResponseDTO::fromEntity).collect(Collectors.toList());
        }

        return orderRepository.findAll().stream()
                .filter(order -> order.getOrderDate() != null && order.getOrderDate().isAfter(fromDate))
                .map(OrderResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
