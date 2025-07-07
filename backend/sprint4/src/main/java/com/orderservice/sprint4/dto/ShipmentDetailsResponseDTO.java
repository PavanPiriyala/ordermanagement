package com.orderservice.sprint4.dto;

import com.orderservice.sprint4.dao.ShipmentItemDAO;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
@Builder
public class ShipmentDetailsResponseDTO {
    private Integer orderId;
    private LocalDateTime orderDate;
    private String orderStatus;
    private String paymentMode;
    private List<ShipmentItemDAO> itmes;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public List<ShipmentItemDAO> getItmes() {
        return itmes;
    }

    public void setItmes(List<ShipmentItemDAO> itmes) {
        this.itmes = itmes;
    }
}
