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

## Relationships

### User and Role
Role 1:N User

### Category and Product
Category 1:N Product

### Product and Supplier
Product N:M Supplier
Resolved through ProductSupplier

### Product and Warehouse
Product N:M Warehouse
Resolved through Inventory

### Inventory and StockMovement
Inventory 1:N StockMovement

### Customer and Order
Customer 1:N Order

### Order and OrderItem
Order 1:N OrderItem

### Product and OrderItem
Product 1:N OrderItem

### User and Notification
User 1:N Notification

### User and AuditLog
User 1:N AuditLog

### User and StockMovement
User 1:N StockMovement