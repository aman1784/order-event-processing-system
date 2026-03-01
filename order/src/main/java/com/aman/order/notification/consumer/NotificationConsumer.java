package com.aman.order.notification.consumer;

import com.aman.order.common.KafkaTopics;
import com.aman.order.common.event.OrderCreatedEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationConsumer {

    private final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(
            topics = KafkaTopics.ORDER_EVENTS,
            groupId = "notification-group"
    )
    public void listen(OrderCreatedEvent event) throws JsonProcessingException {
        String json = mapper.writeValueAsString(event);
        log.info("[NotificationConsumer][Notification Json received]: {}", json); // JSON Format
        log.info("[NotificationConsumer][Notification Java Object received]: {}", event); // Java Object Format
    }
}