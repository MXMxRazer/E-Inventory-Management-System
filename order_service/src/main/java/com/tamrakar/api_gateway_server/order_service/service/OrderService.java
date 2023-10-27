package com.tamrakar.api_gateway_server.order_service.service;

import com.tamrakar.api_gateway_server.order_service.model.OrderRequest;

public interface OrderService {

    String test();
    boolean placeOrders(OrderRequest orderRequest);
}
