package com.orderservice.sprint4.model;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer orderItemId;

//    @Column(name = "order_id")
//    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "id")
    private Order order;

    @NotNull
    @Column(name = "product_id")
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


    @Column(name = "status", length = 50)
    private String status;

    @NotNull
    @Column(name = "seller_id")
    private Integer sellerId;





}