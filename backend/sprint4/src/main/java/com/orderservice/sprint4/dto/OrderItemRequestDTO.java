package com.orderservice.sprint4.dto;

import java.math.BigDecimal;

public class OrderItemRequestDTO {
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
