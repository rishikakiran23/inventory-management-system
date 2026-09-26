package com.inventory.inventory_management_system.service;

import com.inventory.inventory_management_system.entity.Product;
import com.inventory.inventory_management_system.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<Product> getProducts(String search, Pageable pageable) {

        if (search == null || search.isBlank()) {
            return productRepository.findAll(pageable);
        }

        return productRepository.findByNameContainingIgnoreCase(search, pageable);
    }
}