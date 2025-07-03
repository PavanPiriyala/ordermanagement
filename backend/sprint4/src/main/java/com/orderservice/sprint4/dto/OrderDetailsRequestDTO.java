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


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getPromoDiscount() {
        return promoDiscount;
    }

    public void setPromoDiscount(BigDecimal promoDiscount) {
        this.promoDiscount = promoDiscount;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public List<OrderItemRequestDTO> getOrderItemRequestDTOS() {
        return orderItemRequestDTOS;
    }

    public void setOrderItemRequestDTOS(List<OrderItemRequestDTO> orderItemRequestDTOS) {
        this.orderItemRequestDTOS = orderItemRequestDTOS;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
}
