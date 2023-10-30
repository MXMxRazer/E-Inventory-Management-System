package com.tamrakar.order_service.controller;

import com.tamrakar.order_service.events.OrderPlacedEvent;
import com.tamrakar.order_service.model.OrderRequest;
import com.tamrakar.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @Autowired
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    @PostMapping("/place")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrders(orderRequest);
        return "Orders Placed Successfully!";
    }

    @GetMapping("/test")
    public String test() {
        kafkaTemplate.send("notificationTopic", new OrderPlacedEvent("1234Order"));
        return "sent!";
    }

}
