//package com.orderservice.sprint4.repository;
//
//import com.orderservice.sprint4.model.Order;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//public interface OrderRepository extends JpaRepository<Order,Integer> {
//    @Query("SELECT o FROM Order o WHERE o.orderDate >= :fromDate")
//    List<Order> findAllFromDate(@Param("fromDate") LocalDateTime fromDate);
//}

package com.orderservice.sprint4.repository;

import com.orderservice.sprint4.dto.OrderSummaryDTO;
import com.orderservice.sprint4.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = """
    SELECT 
        o.id AS orderId,
        o.user_id AS userId,
        o.order_date AS orderDate,
        o.order_status AS orderStatus,
        o.promo_discount AS promoDiscount,
        o.order_total AS orderTotal,
        (SELECT COUNT(*) FROM order_items oi WHERE oi.order_id = o.id) AS items
    FROM orders o
    WHERE o.order_date >= DATEADD(MONTH, -:months, GETDATE())
""", nativeQuery = true)
    List<OrderSummaryDTO> getOrderSummaryLastXMonths(@Param("months") int months);

}

