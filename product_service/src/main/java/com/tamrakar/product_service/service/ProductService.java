package com.tamrakar.product_service.service;

import com.tamrakar.product_service.dto.ProductRequest;
import com.tamrakar.product_service.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    boolean createProduct(ProductRequest productRequest);

    List<ProductResponse> listAllProducts();
}
