package com.tamrakar.api_gateway_server.product_service.service;

import com.tamrakar.api_gateway_server.product_service.dto.ProductRequest;
import com.tamrakar.api_gateway_server.product_service.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    boolean createProduct(ProductRequest productRequest);

    List<ProductResponse> listAllProducts();
}
