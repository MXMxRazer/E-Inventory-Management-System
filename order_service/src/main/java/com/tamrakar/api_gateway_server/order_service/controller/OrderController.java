package com.tamrakar.api_gateway_server.order_service.controller;

import com.tamrakar.api_gateway_server.order_service.model.OrderRequest;
import com.tamrakar.api_gateway_server.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/place")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrders(orderRequest);
        return "Orders Placed Successfully!";
    }

}
