# Vendex API Design Document

## 📋 Overview

RESTful API specification for the Vendex platform.

## 🔐 Authentication

All requests require JWT token in header:

```
Authorization: Bearer {JWT_TOKEN}
X-Tenant-Id: {ORGANIZATION_ID}
```

## 📊 Core API Endpoints

### Organizations

```
POST   /api/v1/organizations        → Create organization
GET    /api/v1/organizations/{id}   → Get organization
PUT    /api/v1/organizations/{id}   → Update organization
DELETE /api/v1/organizations/{id}   → Delete organization
```

### Stores

```
POST   /api/v1/stores               → Create store
GET    /api/v1/stores/{id}          → Get store
PUT    /api/v1/stores/{id}          → Update store
GET    /api/v1/stores              → List stores
```

### Users

```
POST   /api/v1/users                → Create user
GET    /api/v1/users/{id}           → Get user
PUT    /api/v1/users/{id}           → Update user
GET    /api/v1/users               → List users
```

### Transactions

```
POST   /api/v1/transactions         → Create transaction
GET    /api/v1/transactions/{id}    → Get transaction
GET    /api/v1/transactions        → List transactions
```

### Vendors

```
POST   /api/v1/vendors              → Create vendor
GET    /api/v1/vendors/{id}         → Get vendor
GET    /api/v1/vendors             → List vendors
```

## 📝 Request/Response Format

### Success Response (200)

```json
{
  "success": true,
  "data": {
    "id": "123e4567-e89b-12d3-a456-426614174000",
    "name": "Store A",
    "status": "ACTIVE"
  },
  "timestamp": "2026-07-04T10:30:00Z"
}
```

### Error Response (400/500)

```json
{
  "success": false,
  "error": {
    "code": "VALIDATION_ERROR",
    "message": "Invalid input",
    "details": {}
  },
  "timestamp": "2026-07-04T10:30:00Z"
}
```

---

**Last Updated**: July 4, 2026
