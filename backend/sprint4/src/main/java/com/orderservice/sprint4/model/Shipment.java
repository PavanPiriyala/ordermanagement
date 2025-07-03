package com.orderservice.sprint4.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer shipmentId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "shipment_status")
    private String shipmentStatus;
    @Column(name = "shipment_tracking_id")
    private String shipmentTrackingId;
    @Column(name = "shipment_date")
    private LocalDateTime shippedDate;
    @Column(name = "delivered_date")
    private LocalDateTime deliveredDate;

    @OneToMany(mappedBy = "shipment")
    private List<ShipmentItem> shipmentItems;
}



//CREATE TABLE shipments (
//    id INT PRIMARY KEY IDENTITY,
//    order_id INT,
//    shipment_status VARCHAR(50),       -- e.g., "In Transit", "Delivered"
//    shipment_tracking_id VARCHAR(100),
//    shipment_date DATETIME,
//    delivered_date DATETIME,
//    FOREIGN KEY (order_id) REFERENCES orders(id)
//);