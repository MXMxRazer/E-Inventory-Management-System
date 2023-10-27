package com.tamrakar.api_gateway_server.product_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity (name = "Product_v1")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long product_id;
    private String product_name;
    private int product_price;
    private String product_description;
}
