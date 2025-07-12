package org.campusconnectecommerce.order_service.controller;

import org.campusconnectecommerce.base_domains.dto.Order;
import org.campusconnectecommerce.base_domains.dto.OrderEvent;
import org.campusconnectecommerce.order_service.kafka.OrderProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(" /api/v1/order-producer")
public class OrderController {
    private OrderProducer orderProducer;
    public OrderController(OrderProducer orderProducer)
    {
        this.orderProducer=orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order)
    {
        order.setId(UUID.randomUUID().toString());
        OrderEvent orderEvent=new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status is in : "+orderEvent.getStatus());
        orderProducer.sendmessage(orderEvent);
        return "Order placed successfully";
    }
}
