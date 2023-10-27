package com.tamrakar.api_gateway_server.order_service.repository;

import com.tamrakar.api_gateway_server.order_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
