package com.tamrakar.order_service.service;

import com.tamrakar.order_service.model.OrderRequest;

public interface OrderService {

    String test();
    boolean placeOrders(OrderRequest orderRequest);
}
