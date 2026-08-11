# Inventory Management System

## 1. Project Overview

The Inventory Management System is a backend-focused application designed to help small and medium-sized businesses manage products, suppliers, warehouses, inventory, stock movements, and customer orders through a centralized system.

The system provides role-based access to different users and maintains a reliable record of inventory transactions. It aims to reduce manual inventory management, improve stock accuracy, provide visibility into stock levels, and ensure that inventory changes are properly tracked.

The application will be developed using Java and Spring Boot, with PostgreSQL as the primary database. Additional technologies such as Spring Security, Redis, Apache Kafka, Docker, and AWS will be introduced as the project evolves.

---

## 2. Problem Statement

Businesses that manage inventory manually or through disconnected spreadsheets can face several problems, including inaccurate stock information, difficulty tracking stock movements, delayed identification of low-stock products, and inconsistencies between customer orders and available inventory.

There is also a need to control access to inventory operations based on employee responsibilities and maintain a history of important actions for accountability.

The Inventory Management System aims to address these problems by providing a centralized platform where authorized users can manage products, suppliers, warehouses, inventory levels, stock movements, and orders while maintaining a consistent and auditable record of business operations.

---

## 3. Objectives

The primary objectives of the system are:

* To centralize inventory-related information in a single system.
* To maintain accurate and up-to-date stock levels.
* To manage products, categories, suppliers, and warehouses efficiently.
* To record stock-in, stock-out, and stock-adjustment operations.
* To maintain a history of inventory movements.
* To connect customer orders with inventory availability.
* To prevent orders from exceeding available stock.
* To notify relevant users when inventory reaches a low-stock threshold.
* To provide secure authentication and role-based authorization.
* To maintain audit records for important system operations.
* To provide well-documented REST APIs for system interaction.
* To design the application using maintainable and scalable backend architecture.

---

## 4. User Roles

The initial system will support three primary user roles.

### Admin

The Admin has the highest level of access and is responsible for managing the system.

Responsibilities include:

* Managing users and roles.
* Managing products and categories.
* Managing suppliers.
* Managing warehouses.
* Viewing and managing inventory.
* Viewing orders.
* Viewing audit records and system activity.

### Manager

The Manager is responsible for operational inventory and order management.

Responsibilities include:

* Managing products and categories.
* Managing suppliers.
* Managing warehouse inventory.
* Performing authorized stock operations.
* Managing customer orders.
* Monitoring stock levels.
* Viewing inventory and operational information.

### Staff

Staff users perform day-to-day operational activities.

Responsibilities include:

* Viewing products.
* Viewing inventory.
* Creating customer orders.
* Performing authorized inventory operations.
* Viewing relevant stock movement information.

Access to specific operations will be controlled using role-based authorization.

---

## 5. Core Modules

The system will initially consist of the following modules:

### 5.1 Authentication and User Management

Handles user registration, authentication, authorization, roles, and access control.

### 5.2 Product Management

Handles creation and management of products, including product information, pricing, categories, and stock-related configuration.

### 5.3 Category Management

Organizes products into logical categories for easier management and searching.

### 5.4 Supplier Management

Maintains supplier information and their relationship with products.

### 5.5 Warehouse Management

Maintains information about warehouses or storage locations where inventory is held.

### 5.6 Inventory Management

Maintains current stock levels for products across warehouses.

### 5.7 Stock Movement Management

Records inventory changes such as:

* Stock In
* Stock Out
* Stock Adjustment

Each movement will maintain relevant information such as quantity, product, warehouse, user, reason, and timestamp.

### 5.8 Order Management

Handles customer orders and their associated order items while validating product availability.

### 5.9 Notification Management

Handles system-generated notifications, initially focusing on low-stock conditions and other important inventory events.

### 5.10 Audit Logging

Maintains records of important system operations for accountability, troubleshooting, and monitoring.

---

## 6. Core Business Flow

The primary inventory workflow will operate as follows:

### Product Setup

An authorized user creates a product and assigns it to an appropriate category and supplier.

### Stock Addition

When inventory is received, an authorized user records a stock-in transaction for a specific product and warehouse.

The system updates the available inventory and records the stock movement.

### Order Creation

A customer order is created containing one or more products and their required quantities.

Before confirming the order, the system verifies that sufficient inventory is available.

### Inventory Deduction

Once an order is confirmed, the corresponding inventory quantity is reduced.

A stock-out movement is recorded against the order.

### Low-Stock Detection

The system compares the remaining inventory with the product's configured minimum stock threshold.

If the threshold is reached, the system generates a low-stock event and notification.

### Audit Trail

Important operations such as inventory changes, order creation, and administrative actions are recorded with the responsible user and timestamp.

---

## 7. Scope

### In Scope

The initial version of the project will include:

* User authentication and authorization.
* Role-based access control.
* User and role management.
* Product management.
* Category management.
* Supplier management.
* Warehouse management.
* Inventory management.
* Stock-in operations.
* Stock-out operations.
* Stock adjustments.
* Stock movement history.
* Customer order management.
* Inventory validation during order creation.
* Low-stock detection.
* System notifications for important inventory events.
* Audit logging.
* REST API development.
* API validation and exception handling.
* Unit and integration testing.
* Redis-based caching.
* Kafka-based event processing.
* Docker-based application deployment.
* API documentation using OpenAPI/Swagger.

### Out of Scope

The initial version will not include:

* Accounting and financial management.
* Payroll management.
* Full ERP functionality.
* GST and advanced tax calculation.
* Supplier payment processing.
* Full payment gateway integration.
* Shipping and logistics management.
* Advanced demand forecasting.
* AI-based inventory prediction.
* Native Android or iOS applications.
* Advanced business intelligence and analytics.
* Multi-company enterprise management.
* Complex warehouse automation or hardware integration.

These features may be considered as future extensions after the core system is completed.
