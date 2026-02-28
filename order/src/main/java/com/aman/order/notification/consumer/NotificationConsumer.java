package com.aman.order.notification.consumer;

import com.aman.order.common.KafkaTopics;
import com.aman.order.common.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationConsumer {

    @KafkaListener(
            topics = KafkaTopics.ORDER_EVENTS,
            groupId = "notification-group"
    )
    public void listen(OrderCreatedEvent event) {

        log.info("[NotificationConsumer] Notification received: {}", event);

        log.info("[NotificationConsumer] Email sent for order {}", event.getOrderId());
    }
}