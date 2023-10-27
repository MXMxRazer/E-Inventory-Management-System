package com.tamrakar.api_gateway_server.product_service.repository;

import com.tamrakar.api_gateway_server.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
