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
    @JoinColumn(name = "id")
    private Order order;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "invoice_Date")
    private LocalDateTime invoiceDate;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "invoice_amount")
    private BigDecimal invoiceAmount;
}
