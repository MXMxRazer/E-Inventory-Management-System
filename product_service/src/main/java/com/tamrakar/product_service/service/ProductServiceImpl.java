package com.tamrakar.product_service.service;

import com.tamrakar.product_service.dto.ProductRequest;
import com.tamrakar.product_service.dto.ProductResponse;
import com.tamrakar.product_service.entity.Product;
import com.tamrakar.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public boolean createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .product_name(productRequest.getProductName())
                .product_description(productRequest.getProductDesc())
                .product_price(productRequest.getProductPrice())
                .build();

        productRepository.save(product);
        log.info("Product Created!");
        return true;
    }

    @Override
    public List<ProductResponse> listAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::arrangeAllProducts).toList();
    }

    private ProductResponse arrangeAllProducts(Product product) {
        return ProductResponse.builder()
                .productId(product.getProduct_id())
                .productName(product.getProduct_name())
                .productPrice(product.getProduct_price())
                .productDescription(product.getProduct_description())
                .build();
    }
}
