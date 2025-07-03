package com.orderservice.sprint4.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface OrderSummaryDTO {
    Integer getOrderId();
    Integer getUserId();
    LocalDateTime getOrderDate();
    String getOrderStatus();
    BigDecimal getOrderTotal();
    BigDecimal getPromoDiscount();  // ➕ NEW
}
