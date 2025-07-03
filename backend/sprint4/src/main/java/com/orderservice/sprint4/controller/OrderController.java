package com.orderservice.sprint4.controller;

import com.orderservice.sprint4.dto.OrderSummaryDTO;
import com.orderservice.sprint4.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {

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
