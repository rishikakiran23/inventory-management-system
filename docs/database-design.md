# Database Design

## Entities

1. User
2. Role
3. Product
4. Category
5. Supplier
6. Warehouse
7. Inventory
8. StockMovement
9. Customer
10. Order
11. OrderItem
12. Notification
13. AuditLog

---

## Relationships

- Role 1:N User
- Category 1:N Product
- Product N:M Supplier — resolved through ProductSupplier
- Product N:M Warehouse — resolved through Inventory
- Inventory 1:N StockMovement
- User 1:N StockMovement
- Customer 1:N Order
- Order 1:N OrderItem
- Product 1:N OrderItem
- User 1:N Notification
- User 1:N AuditLog

---

# Table Design

## 1. roles

| Column | Type | Constraint |
|---|---|---|
| id | BIGINT | PRIMARY KEY |
| name | VARCHAR(50) | NOT NULL, UNIQUE |
| description | VARCHAR(255) | NULL |
| created_at | TIMESTAMP | NOT NULL |

---

## 2. users

| Column | Type | Constraint |
|---|---|---|
| id | BIGINT | PRIMARY KEY |
| username | VARCHAR(50) | NOT NULL, UNIQUE |
| email | VARCHAR(100) | NOT NULL, UNIQUE |
| password | VARCHAR(255) | NOT NULL |
| role_id | BIGINT | NOT NULL, FOREIGN KEY → roles.id |
| is_active | BOOLEAN | NOT NULL |
| created_at | TIMESTAMP | NOT NULL |
| updated_at | TIMESTAMP | NOT NULL |

---

## 3. categories

| Column | Type | Constraint |
|---|---|---|
| id | BIGINT | PRIMARY KEY |
| name | VARCHAR(100) | NOT NULL, UNIQUE |
| description | VARCHAR(255) | NULL |
| created_at | TIMESTAMP | NOT NULL |
| updated_at | TIMESTAMP | NOT NULL |

---

## 4. products

| Column | Type | Constraint |
|---|---|---|
| id | BIGINT | PRIMARY KEY |
| sku | VARCHAR(50) | NOT NULL, UNIQUE |
| name | VARCHAR(150) | NOT NULL |
| description | TEXT | NULL |
| price | DECIMAL(12,2) | NOT NULL |
| reorder_level | INT | NOT NULL |
| category_id | BIGINT | NOT NULL, FOREIGN KEY → categories.id |
| is_active | BOOLEAN | NOT NULL |
| created_at | TIMESTAMP | NOT NULL |
| updated_at | TIMESTAMP | NOT NULL |

---

## 5. suppliers

| Column | Type | Constraint |
|---|---|---|
| id | BIGINT | PRIMARY KEY |
| name | VARCHAR(150) | NOT NULL |
| email | VARCHAR(100) | NULL |
| phone | VARCHAR(20) | NULL |
| address | TEXT | NULL |
| is_active | BOOLEAN | NOT NULL |
| created_at | TIMESTAMP | NOT NULL |
| updated_at | TIMESTAMP | NOT NULL |

---

## 6. product_suppliers

| Column | Type | Constraint |
|---|---|---|
| product_id | BIGINT | PRIMARY KEY, FOREIGN KEY → products.id |
| supplier_id | BIGINT | PRIMARY KEY, FOREIGN KEY → suppliers.id |
| supplier_product_code | VARCHAR(100) | NULL |
| created_at | TIMESTAMP | NOT NULL |

> `product_id + supplier_id` form a composite primary key.

---

## 7. warehouses

| Column | Type | Constraint |
|---|---|---|
| id | BIGINT | PRIMARY KEY |
| name | VARCHAR(100) | NOT NULL |
| code | VARCHAR(30) | NOT NULL, UNIQUE |
| address | TEXT | NULL |
| is_active | BOOLEAN | NOT NULL |
| created_at | TIMESTAMP | NOT NULL |
| updated_at | TIMESTAMP | NOT NULL |

---

## 8. inventory

| Column | Type | Constraint |
|---|---|---|
| id | BIGINT | PRIMARY KEY |
| product_id | BIGINT | NOT NULL, FOREIGN KEY → products.id |
| warehouse_id | BIGINT | NOT NULL, FOREIGN KEY → warehouses.id |
| quantity | INT | NOT NULL |
| updated_at | TIMESTAMP | NOT NULL |

### Additional Constraint

```text
UNIQUE(product_id, warehouse_id)```

## ER Diagram

```mermaid
erDiagram
    ROLE ||--o{ USER : has
    CATEGORY ||--o{ PRODUCT : contains
    PRODUCT ||--o{ PRODUCT_SUPPLIER : supplied_by
    SUPPLIER ||--o{ PRODUCT_SUPPLIER : supplies
    PRODUCT ||--o{ INVENTORY : stocked_as
    WAREHOUSE ||--o{ INVENTORY : stores
    INVENTORY ||--o{ STOCK_MOVEMENT : records
    USER ||--o{ STOCK_MOVEMENT : performs
    CUSTOMER ||--o{ ORDERS : places
    ORDERS ||--o{ ORDER_ITEM : contains
    PRODUCT ||--o{ ORDER_ITEM : included_in
    USER ||--o{ NOTIFICATION : receives
    USER ||--o{ AUDIT_LOG : generates