package com.orderservice.sprint4.controller;

import com.orderservice.sprint4.dto.ShipmentDetailsResponseDTO;
import com.orderservice.sprint4.model.ShipmentItem;
import com.orderservice.sprint4.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipment")
@CrossOrigin("*")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping("/shipment-times/order/{orderId}")
    private ResponseEntity<?> getShipmentItemsByOrderId(@PathVariable Integer orderId){
        ShipmentDetailsResponseDTO responseDTO = shipmentService.getShipmentItemsByOrderId(orderId);
        return ResponseEntity.ok(responseDTO);
    }
}
