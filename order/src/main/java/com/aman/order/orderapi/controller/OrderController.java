package com.aman.order.orderapi.controller;

import com.aman.order.common.event.OrderCreatedEvent;
import com.aman.order.orderapi.service.OrderProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducerService producerService;

    @PostMapping
    public String createOrder(@RequestBody OrderCreatedEvent event) {

        producerService.sendOrderEvent(event);

        return "Order event sent to Kafka";
    }
}