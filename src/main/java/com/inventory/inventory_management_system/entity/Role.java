package com.inventory.inventory_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity // Tells JPA this class represents a database entity
@Table(name = "roles") // Maps it specifically to roles
@Getter // Lombok annotations - Generates getters/setters/constructors/builder
@Setter // Lombok annotations - Generates getters/setters/constructors/builder
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Database generates the ID
    private Long id;

    @Column(nullable = false, unique = true, length = 50) // Defines column constraints
    private String name;

    @Column(length = 255)
    private String description;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; //Spring/Hibernate's default naming strategy converts camelCase to snake_case. This field will become created_at in table.

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist // Runs before a new record is inserted
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate // Runs before an existing record is updated
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}