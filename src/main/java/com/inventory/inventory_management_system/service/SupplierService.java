package com.inventory.inventory_management_system.service;

import com.inventory.inventory_management_system.entity.Supplier;
import com.inventory.inventory_management_system.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.inventory.inventory_management_system.dto.SupplierRequest;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public Page<Supplier> getSuppliers(Pageable pageable) {
        return supplierRepository.findAll(pageable);
    }

    public Supplier createSupplier(SupplierRequest request) {

        Supplier supplier = Supplier.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .isActive(true)
                .build();

        return supplierRepository.save(supplier);
    }
}