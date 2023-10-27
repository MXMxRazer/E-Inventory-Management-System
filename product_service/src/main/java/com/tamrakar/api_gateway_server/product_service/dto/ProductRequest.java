package com.tamrakar.api_gateway_server.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private String productName;
    private int productPrice;
    private String productDesc;
}
