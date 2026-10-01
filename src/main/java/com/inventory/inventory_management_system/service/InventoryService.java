package com.inventory.inventory_management_system.service;

import com.inventory.inventory_management_system.dto.InventoryRequest;
import com.inventory.inventory_management_system.entity.Inventory;
import com.inventory.inventory_management_system.entity.Product;
import com.inventory.inventory_management_system.entity.Warehouse;
import com.inventory.inventory_management_system.repository.InventoryRepository;
import com.inventory.inventory_management_system.repository.ProductRepository;
import com.inventory.inventory_management_system.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;

    public Page<Inventory> getInventory(Pageable pageable) {
        return inventoryRepository.findAll(pageable);
    }

    public Inventory createInventory(InventoryRequest request) {

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Warehouse warehouse = warehouseRepository.findById(request.getWarehouseId())
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));

        Inventory inventory = Inventory.builder()
                .product(product)
                .warehouse(warehouse)
                .quantity(request.getQuantity())
                .build();

        return inventoryRepository.save(inventory);
    }
}