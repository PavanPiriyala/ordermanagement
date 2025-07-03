package com.orderservice.sprint4.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "order_invoice")
public class OrderInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer invoiceId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "invoice_Date")
    private LocalDateTime invoiceDate;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "invoice_amount")
    private BigDecimal invoiceAmount;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
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
