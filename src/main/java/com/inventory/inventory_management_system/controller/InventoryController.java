package com.inventory.inventory_management_system.controller;

import com.inventory.inventory_management_system.dto.InventoryRequest;
import com.inventory.inventory_management_system.entity.Inventory;
import com.inventory.inventory_management_system.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public Page<Inventory> getInventory(Pageable pageable) {
        return inventoryService.getInventory(pageable);
    }

    @PostMapping
    public ResponseEntity<Inventory> createInventory(
            @Valid @RequestBody InventoryRequest request) {

        Inventory inventory = inventoryService.createInventory(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(inventory);
    }
}