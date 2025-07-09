package com.orderservice.sprint4.service;

import com.orderservice.sprint4.dao.ShipmentItemDAO;
import com.orderservice.sprint4.dto.InvoiceResponseDTO;
import com.orderservice.sprint4.dto.OrderDetailsResponseDTO;
import com.orderservice.sprint4.dto.ShipmentDetailsResponseDTO;
import com.orderservice.sprint4.exception.InvoiceNotFoundException;
import com.orderservice.sprint4.exception.OrderNotFoundException;
import com.orderservice.sprint4.exception.ShipmentItemsNotFoundException;
import com.orderservice.sprint4.model.Order;
import com.orderservice.sprint4.model.OrderInvoice;
import com.orderservice.sprint4.repository.OrderInvoiceRepository;
import com.orderservice.sprint4.repository.OrderRepository;
import com.orderservice.sprint4.repository.custom.CustomShipmentItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderInvoiceRepository orderInvoiceRepository;

    @Autowired
    private CustomShipmentItemRepository customShipmentItemRepository;

    @Override
    public ShipmentDetailsResponseDTO getShipmentItemsByOrderId(Integer orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));

        List<ShipmentItemDAO> items = customShipmentItemRepository.getShipmentItemsByOrderId(orderId);
        if (items == null || items.isEmpty()) {
            throw new ShipmentItemsNotFoundException(orderId);
        }

        InvoiceResponseDTO invoiceResponseDTO = orderInvoiceRepository.getInvoiceByOrderId(orderId);
        if (invoiceResponseDTO == null) {
            throw new InvoiceNotFoundException(orderId);
        }

//        //Write Exceptions for above three calls

        ShipmentDetailsResponseDTO dto = new ShipmentDetailsResponseDTO();
        dto.setOrderId(order.getOrderId());
        dto.setOrderDate(order.getOrderDate());
        dto.setOrderStatus(order.getOrderStatus());
        dto.setPaymentMode(invoiceResponseDTO.getPaymentMode());
        return dto;
    }
}
