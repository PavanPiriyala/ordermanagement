package com.orderservice.sprint4.dto;


import com.orderservice.sprint4.model.Order;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderResponseDTO {
    private Integer orderId;
    private Integer userId;
    private LocalDateTime orderDate;
    private String orderStatus;
    private BigDecimal promoDiscount;
    private BigDecimal orderTotal;


    public static OrderResponseDTO fromEntity(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setOrderId(order.getOrderId());
        dto.setUserId(order.getUserId());
        dto.setOrderStatus(order.getOrderStatus());
        dto.setOrderTotal(order.getOrderTotal());
        dto.setOrderDate(order.getOrderDate());
        dto.setPromoDiscount(order.getPromoDiscount());
        return dto;
    }
}
