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


    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public String getShipmentTrackingId() {
        return shipmentTrackingId;
    }

    public void setShipmentTrackingId(String shipmentTrackingId) {
        this.shipmentTrackingId = shipmentTrackingId;
    }

    public LocalDateTime getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDateTime shippedDate) {
        this.shippedDate = shippedDate;
    }

    public LocalDateTime getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(LocalDateTime deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public List<ShipmentItem> getShipmentItems() {
        return shipmentItems;
    }

    public void setShipmentItems(List<ShipmentItem> shipmentItems) {
        this.shipmentItems = shipmentItems;
    }
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