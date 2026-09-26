package com.inventory.inventory_management_system.controller;

import com.inventory.inventory_management_system.entity.Product;
import com.inventory.inventory_management_system.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.inventory.inventory_management_system.dto.ProductRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<Product> getProducts(
            @RequestParam(required = false) String search,
            Pageable pageable) {

        return productService.getProducts(search, pageable);
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(
            @Valid @RequestBody ProductRequest request) {

        return ResponseEntity.ok().build();
    }
}