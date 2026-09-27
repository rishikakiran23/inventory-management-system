package com.inventory.inventory_management_system.service;

import com.inventory.inventory_management_system.entity.Product;
import com.inventory.inventory_management_system.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.inventory.inventory_management_system.dto.ProductRequest;
import com.inventory.inventory_management_system.entity.Category;
import com.inventory.inventory_management_system.repository.CategoryRepository;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Page<Product> getProducts(String search, Pageable pageable) {

        if (search == null || search.isBlank()) {
            return productRepository.findAll(pageable);
        }

        return productRepository.findByNameContainingIgnoreCase(search, pageable);
    }

    public Product createProduct(ProductRequest request) {

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = Product.builder()
                .sku(request.getSku())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .reorderLevel(request.getReorderLevel())
                .category(category)
                .isActive(true)
                .build();

        return productRepository.save(product);
    }
}