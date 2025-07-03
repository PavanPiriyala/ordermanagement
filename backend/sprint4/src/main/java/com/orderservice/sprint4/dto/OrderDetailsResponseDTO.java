package com.orderservice.sprint4.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDetailsResponseDTO {
    private Integer orderId;
    private Integer userId;
    private LocalDateTime orderDate;
    private String orderStatus;
    private BigDecimal promoDiscount;
    private BigDecimal orderTotal;
    private String paymentMode;
    private String invoiceNumber;
    private LocalDateTime invoiceDate;
    private BigDecimal invoiceAmount;

    private List<OrderItemResponseDTO> orderItems;

}
