package com.orderservice.sprint4.controller;

import com.orderservice.sprint4.dto.OrderDetailsRequestDTO;
import com.orderservice.sprint4.dto.OrderDetailsResponseDTO;
import com.orderservice.sprint4.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderDetailsRequestDTO dto){
        try{
            String invoiceNumber = orderService.createOrderTransaction(dto);
            return ResponseEntity.ok("Order created successfully with invoice number: "+invoiceNumber);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error Occurred: " + e.getMessage());
        }
    }


    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDetailsResponseDTO> getOrderDetails(@PathVariable Integer orderId) {
        try {
            OrderDetailsResponseDTO orderDetails = orderService.getOrderDetails(orderId);
            return ResponseEntity.ok(orderDetails);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }







}
