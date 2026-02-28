package com.aman.order.analytics.consumer;

import com.aman.order.common.KafkaTopics;
import com.aman.order.common.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AnalyticsConsumer {

    @KafkaListener(
            topics = KafkaTopics.ORDER_EVENTS,
            groupId = "analytics-group"
    )
    public void listen(OrderCreatedEvent event) {

        log.info("[AnalyticsConsumer] Analytics received: {}", event);

        log.info("[AnalyticsConsumer] Updating analytics for order {}", event.getOrderId());
    }
}