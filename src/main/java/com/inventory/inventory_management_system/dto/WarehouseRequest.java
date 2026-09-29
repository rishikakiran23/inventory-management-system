package com.inventory.inventory_management_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseRequest {

    @NotBlank(message = "Warehouse name is required")
    @Size(max = 100, message = "Warehouse name must not exceed 100 characters")
    private String name;

    @NotBlank(message = "Warehouse code is required")
    @Size(max = 30, message = "Warehouse code must not exceed 30 characters")
    private String code;

    private String address;
}