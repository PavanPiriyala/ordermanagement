package com.orderservice.sprint4.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "order_items")
public class OrderItem {

    @Id
    @Column(name = "id")
    private Integer orderItemId;

    @Column(name = "order_iD")
    private Integer orderId;

    @Column(name = "product_iD")
    private Integer productId;

    @Column(name = "sku", length = 50)
    private String sku;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "discount", precision = 10, scale = 2)
    private BigDecimal discount;

    @Column(name = "final_price", precision = 10, scale = 2)
    private BigDecimal finalPrice;

    @Column(name = "size", length = 20)
    private String size;

    @Column(name = "color", length = 30)
    private String color;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "seller_id")
    private Integer sellerId;
}