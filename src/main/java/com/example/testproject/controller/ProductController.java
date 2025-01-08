package com.example.testproject.controller;

import com.example.testproject.data.dto.ProductDto;
import com.example.testproject.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value="/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId){
        return productService.getProduct(productId);
    }

    @PostMapping(value="/product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto){
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        ProductDto response = productService
                .saveProduct(productId, productName, productPrice, productStock);

        LOGGER.info(
                "[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {}",
                response.getProductId(), response.getProductName(), response.getProductPrice(), response.getProductStock()
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(value="/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId){
        return null;
    }
}
