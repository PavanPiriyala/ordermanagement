package com.orderservice.sprint4.controller;



import java.util.List;
=======
import com.orderservice.sprint4.dto.OrderDetailsRequestDTO;
import com.orderservice.sprint4.dto.OrderDetailsResponseDTO;
import com.orderservice.sprint4.dto.OrderSummaryDTO;
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

    @GetMapping("/list/{month}")
    public ResponseEntity<?> getOrdersList(@PathVariable Integer month){
        try{
            List<OrderSummaryDTO> orders = orderService.getOrders(month);
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }







    @Autowired
    private OrderService orderService;

    @GetMapping("/history/{months}")
    public List<OrderSummaryDTO> getOrderHistory(@PathVariable int months) {
        return orderService.getOrderHistoryByMonths(months);
    }
}


//package com.orderservice.sprint4.controller;
//
//import com.orderservice.sprint4.dto.OrderResponseDTO;
//import com.orderservice.sprint4.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/orders")
//@CrossOrigin("*")
//public class OrderController {
//
//    @Autowired
//    private OrderService orderService;
//
//    @GetMapping("/history")
//    public List<OrderResponseDTO> getOrderHistory(@RequestParam(defaultValue = "6months") String range) {
//        return orderService.getOrdersByRange(range);
//    }
//}
//
