package com.inventory.inventory_management_system.service;

import com.inventory.inventory_management_system.dto.SupplierRequest;
import com.inventory.inventory_management_system.dto.WarehouseRequest;
import com.inventory.inventory_management_system.entity.Supplier;
import com.inventory.inventory_management_system.entity.Warehouse;
import com.inventory.inventory_management_system.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public Page<Warehouse> getWarehouses(Pageable pageable) {
        return warehouseRepository.findAll(pageable);
    }

    public Warehouse createWarehouse(WarehouseRequest request) {

        Warehouse warehouse = Warehouse.builder()
                .name(request.getName())
                .code(request.getCode())
                .address(request.getAddress())
                .isActive(true)
                .build();

        return warehouseRepository.save(warehouse);
    }
}