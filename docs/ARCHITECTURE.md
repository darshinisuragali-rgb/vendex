# Vendex Platform Architecture

## 📐 System Architecture Overview

```
┌─────────────────────────────────────────────────────────┐
│                   Client Layer                          │
│         (React Web & Mobile Applications)              │
└────────────────┬────────────────────────────────────────┘
                 │ HTTPS / REST API
┌────────────────▼────────────────────────────────────────┐
│              API Gateway Layer                          │
│        (Request Routing & Authentication)              │
└────────────────┬────────────────────────────────────────┘
                 │
┌────────────────▼────────────────────────────────────────┐
│         Business Logic Layer (Spring Boot)             │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐ │
│  │   User Mgmt  │  │  Spend Ctrl  │  │  Approval    │ │
│  ├──────────────┤  ├──────────────┤  ├──────────────┤ │
│  │  Store Mgmt  │  │  UPI Payment │  │  Risk Mgmt   │ │
│  ├──────────────┤  ├──────────────┤  ├──────────────┤ │
│  │  Vendor Mgmt │  │  Audit Trail │  │  Reporting   │ │
│  └──────────────┘  └──────────────┘  └──────────────┘ │
└────────────────┬────────────────────────────────────────┘
                 │
┌────────────────▼────────────────────────────────────────┐
│           Data Access Layer (JPA/Hibernate)            │
└────────────────┬────────────────────────────────────────┘
                 │
┌────────────────▼────────────────────────────────────────┐
│        Database Layer (PostgreSQL)                      │
└─────────────────────────────────────────────────────────┘
```

## 🏛️ Multi-Tenant Architecture

```
Vendex Platform
│
├── Organization 1 (Retail Chain A)
│   ├── Store 1
│   ├── Store 2
│   └── Store 3
│
├── Organization 2 (Hospital Chain B)
│   ├── Hospital 1
│   └── Hospital 2
│
└── Organization 3 (QSR Chain C)
    ├── Restaurant 1
    └── Restaurant 2
```

## 🔐 Security Architecture

### Authentication & Authorization

```
User Login
    ↓
[Credential Validation]
    ↓
[JWT Token Generation]
    ↓
[Role-Based Access Control]
    ↓
[Multi-Tenant Context Isolation]
    ↓
Authorized Access
```

## 💳 Payment Flow Architecture

```
User Initiates Spend
        ↓
[Spending Policy Check]
        ↓
[Approval Workflow]
        ↓
[Risk Assessment]
        ↓
[Payment Intent Creation]
        ↓
[UPI Payment Processing]
        ↓
[Virtual Account Deduction]
        ↓
[Transaction Recording]
        ↓
[Audit Trail Update]
        ↓
Payment Complete
```

---

**Last Updated**: July 4, 2026
