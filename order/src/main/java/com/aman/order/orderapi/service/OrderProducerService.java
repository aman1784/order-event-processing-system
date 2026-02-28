package com.aman.order.orderapi.service;

import com.aman.order.common.KafkaTopics;
import com.aman.order.common.event.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendOrderEvent(OrderCreatedEvent event) {

        kafkaTemplate.send(
                KafkaTopics.ORDER_EVENTS,
                event.getOrderId(),
                event
        );

        log.info("[OrderProducerService] Order event sent to Kafka: {}", event);
    }
}