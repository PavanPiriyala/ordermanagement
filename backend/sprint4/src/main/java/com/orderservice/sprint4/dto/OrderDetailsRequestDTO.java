package com.orderservice.sprint4.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDetailsRequestDTO {
    private Integer userId;
    private LocalDateTime orderDate;
    private String orderStatus;
    private BigDecimal promoDiscount;
    private BigDecimal orderTotal;
    private List<OrderItemRequestDTO> orderItemRequestDTOS;
    private String paymentMode;

}
