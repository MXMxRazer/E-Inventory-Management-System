package ca.tamrakar.notifcation_service;

import ca.tamrakar.notifcation_service.events.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@SpringBootApplication
public class NotificationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "notificationTopic", groupId = "group_id")
    public void listen(OrderPlacedEvent orderPlacedEvent) {
        System.out.println("Received Messasge in group - group-id: " + orderPlacedEvent.getOrderNumber());
    }
}