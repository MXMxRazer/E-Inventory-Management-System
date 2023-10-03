package com.tamrakar.product_service.controller;

import com.tamrakar.product_service.dto.ProductRequest;
import com.tamrakar.product_service.dto.ProductResponse;
import com.tamrakar.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody ProductRequest productRequest) {
        if (productService.createProduct(productRequest)) {
            return "success!";
        }
        return "failed!";
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> listProducts() {
        return productService.listAllProducts();
    }
}
