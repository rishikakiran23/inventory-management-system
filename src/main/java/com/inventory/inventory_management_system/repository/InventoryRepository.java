package com.inventory.inventory_management_system.repository;

import com.inventory.inventory_management_system.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findByProductIdAndWarehouseId(
            Long productId,
            Long warehouseId
    );
}