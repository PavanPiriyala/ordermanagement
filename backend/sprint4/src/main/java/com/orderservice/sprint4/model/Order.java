package com.orderservice.sprint4.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    private Integer orderId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "order_status", length = 50)
    private String orderStatus;

    @Column(name = "order_total", precision = 10, scale = 2)
    private BigDecimal orderTotal;

}