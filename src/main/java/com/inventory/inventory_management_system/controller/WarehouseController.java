package com.inventory.inventory_management_system.controller;

import com.inventory.inventory_management_system.dto.SupplierRequest;
import com.inventory.inventory_management_system.dto.WarehouseRequest;
import com.inventory.inventory_management_system.entity.Supplier;
import com.inventory.inventory_management_system.entity.Warehouse;
import com.inventory.inventory_management_system.service.WarehouseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/warehouses")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    @GetMapping
    public Page<Warehouse> getWarehouses(Pageable pageable) {
        return warehouseService.getWarehouses(pageable);
    }

    @PostMapping
    public ResponseEntity<Warehouse> createWarehouse(
            @Valid @RequestBody WarehouseRequest request) {

        Warehouse warehouse = warehouseService.createWarehouse(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(warehouse);
    }
}