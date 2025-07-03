package com.orderservice.sprint4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "shipment_items")
public class ShipmentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    @ManyToOne
    @JoinColumn(name = "order_item_id")
    private OrderItem orderItem;

    @Column(name = "item_status")
    private String itemStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }
}


//CREATE TABLE shipment_items (
//    id INT PRIMARY KEY IDENTITY,
//    shipment_id INT,
//    order_item_id INT,
//    item_status VARCHAR(50),           -- e.g., "In Transit", "Delivered"
//    FOREIGN KEY (shipment_id) REFERENCES shipments(id),
//    FOREIGN KEY (order_item_id) REFERENCES order_items(id)
//);