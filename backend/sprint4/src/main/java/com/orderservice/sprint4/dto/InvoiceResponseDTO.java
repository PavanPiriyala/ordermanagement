package com.orderservice.sprint4.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceResponseDTO {
    private Integer invoiceId;
    private Integer orderId;
    private String invioceNumber;
    private LocalDateTime invoiceDate;
    private String paymentMode;
    private BigDecimal invoiceAmount;

    public InvoiceResponseDTO(){}

    public InvoiceResponseDTO(Integer invoiceId, Integer orderId, String invioceNumber, LocalDateTime invoiceDate, String paymentMode, BigDecimal invoiceAmount) {
        this.invoiceId = invoiceId;
        this.orderId = orderId;
        this.invioceNumber = invioceNumber;
        this.invoiceDate = invoiceDate;
        this.paymentMode = paymentMode;
        this.invoiceAmount = invoiceAmount;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getInvioceNumber() {
        return invioceNumber;
    }

    public void setInvioceNumber(String invioceNumber) {
        this.invioceNumber = invioceNumber;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }
}
