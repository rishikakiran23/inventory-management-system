package com.inventory.inventory_management_system.controller;

import com.inventory.inventory_management_system.entity.Supplier;
import com.inventory.inventory_management_system.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.inventory.inventory_management_system.dto.SupplierRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping
    public Page<Supplier> getSuppliers(Pageable pageable) {
        return supplierService.getSuppliers(pageable);
    }

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(
            @Valid @RequestBody SupplierRequest request) {

        Supplier supplier = supplierService.createSupplier(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(supplier);
    }
}