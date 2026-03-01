package com.aman.order.analytics.consumer;

import com.aman.order.common.KafkaTopics;
import com.aman.order.common.event.OrderCreatedEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AnalyticsConsumer {

    private final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(
            topics = KafkaTopics.ORDER_EVENTS,
            groupId = "analytics-group"
    )
    public void listen(OrderCreatedEvent event) throws JsonProcessingException {
        String json = mapper.writeValueAsString(event);
        log.info("[AnalyticsConsumer][Analytics JSON received]: {}", json); // JSON Format
        log.info("[AnalyticsConsumer][Analytics Java Object received]: {}", event); // Java Object Format
    }
}