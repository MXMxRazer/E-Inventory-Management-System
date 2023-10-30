package com.tamrakar.order_service.service;

import com.netflix.discovery.converters.Auto;
import com.tamrakar.order_service.dto.OrderLineItemsDto;
import com.tamrakar.order_service.entity.OrderLineItems;
import com.tamrakar.order_service.events.OrderPlacedEvent;
import com.tamrakar.order_service.model.OrderRequest;
import com.tamrakar.order_service.repository.OrderRepository;
import com.tamrakar.order_service.model.InventoryResponse;
import com.tamrakar.order_service.entity.Order;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    @Autowired
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    @Override
    public String test() {
        return "TESTING FROM SERVICE MODULE!!!";
    }

    @Override
    public boolean placeOrders(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrder_number(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDto()
                .stream()
                .map(this::ArrangedOrders)
                .toList();

        order.setOrder_line_items_list(orderLineItems);

        List<String> itemNames = order.getOrder_line_items_list().stream()
                .map(OrderLineItems::getItem_name)
                .toList();

            InventoryResponse[] itemAval = webClientBuilder.build().get()
                    .uri("http://inventory-service/api/inventory/check",
                            uriBuilder -> uriBuilder.queryParam("itemName", itemNames).build())
                    .retrieve()
                    .bodyToMono(InventoryResponse[].class)
                    .block();

            boolean allItemsAval = Arrays.stream(itemAval)
                    .allMatch(InventoryResponse::isAval);

            if (allItemsAval) {
                orderRepository.save(order);
                kafkaTemplate.send("notificationTopic", new OrderPlacedEvent(order.getOrder_number()));
                return true;
            } else {
                throw new IllegalStateException("NOT IN STOCK!");
            }
    }

    private OrderLineItems ArrangedOrders(OrderLineItemsDto order) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setItem_name(order.getOrderLineItemsName());
        orderLineItems.setItem_price(order.getOrderLineItemsPrice());
        orderLineItems.setItem_quantity(order.getOrderLineItemsQuantity());
        return orderLineItems;
    }


}
