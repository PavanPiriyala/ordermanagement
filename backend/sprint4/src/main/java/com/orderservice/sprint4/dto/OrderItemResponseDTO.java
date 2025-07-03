package com.orderservice.sprint4.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemResponseDTO {
    private Integer orderItemId;
    private Integer productId;
    private String sku;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal discount;
    private BigDecimal finalPrice;
    private String size;
    private String status;
    private Integer sellerId;
}
