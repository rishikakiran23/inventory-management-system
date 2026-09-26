package com.inventory.inventory_management_system.repository;

import com.inventory.inventory_management_system.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameContainingIgnoreCase(
            String name,
            Pageable pageable
    );
}