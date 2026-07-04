# Vendex - Enterprise Spend Management Platform

[![GitHub](https://img.shields.io/badge/GitHub-darshinisuragali--rgb%2Fvendex-blue)](https://github.com/darshinisuragali-rgb/vendex)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)
[![Status](https://img.shields.io/badge/Status-In%20Development-orange)](#)

## 🎯 Project Overview

**Vendex** is a multi-tenant enterprise spend management platform designed to eliminate traditional employee reimbursement processes. It enables direct business expense payments through company-controlled virtual accounts for multi-location businesses.

### Key Problems Solved

- ❌ Eliminates employee reimbursement burden
- ✅ Real-time expense visibility and control
- ✅ Policy-driven spending governance
- ✅ Faster operational processes
- ✅ Enhanced audit trails and compliance

### Target Industries

- Retail & Jewelry Chains
- Quick Service Restaurants (QSR)
- Hospitals & Healthcare
- Hotels & Hospitality
- Manufacturing & Logistics (future)

---

## 🏗️ Architecture Overview

```
Vendex Platform
├── Frontend (React)
│   └── Mobile-first spend management UI
├── Backend (Java/Spring Boot)
│   └── Multi-tenant spend orchestration engine
├── Database (PostgreSQL)
│   └── Enterprise-grade data persistence
└── Infrastructure (Azure)
    └── Cloud-native deployment
```

---

## 🚀 Quick Start

### Prerequisites

- Node.js 18+ (Frontend)
- Java 17+ (Backend)
- Docker & Docker Compose
- PostgreSQL 14+
- Git

### Setup Development Environment

```bash
# Clone repository
git clone https://github.com/darshinisuragali-rgb/vendex.git
cd vendex

# Setup frontend
cd frontend
npm install
npm start

# Setup backend (in another terminal)
cd backend
mvn clean install
mvn spring-boot:run

# Access application
Frontend: http://localhost:3000
Backend API: http://localhost:8080
```

---

## 📦 Technology Stack

| Layer | Technology | Version |
|-------|-----------|---------|
| **Frontend** | React | 18.x |
| **Backend** | Java/Spring Boot | 3.x |
| **Database** | PostgreSQL | 14+ |
| **Infrastructure** | Azure | - |
| **Container** | Docker | Latest |
| **API** | REST/HTTP | - |
| **Payment** | UPI Integration | - |

---

## 📋 MVP Features

### Core Functionality

- [x] Multi-Tenant Architecture
- [x] Merchant Onboarding
- [x] Store Management
- [x] User Management
- [x] Department Management
- [x] Payment Intent Framework
- [x] Vendor Management
- [x] UPI Payments
- [x] Approval Engine
- [x] Risk Framework
- [x] Notifications
- [x] Reporting
- [x] Audit Framework
- [x] Security Framework
- [x] Offline Draft Capability

---

## 📁 Project Structure

```
vendex/
├── frontend/                    # React Application
├── backend/                     # Java/Spring Boot Application
├── infrastructure/              # Infrastructure as Code
├── docs/                        # Documentation
├── .github/workflows/           # CI/CD Pipelines
├── docker-compose.yml           # Local development
├── .env.example                 # Environment template
├── LICENSE                      # MIT License
└── README.md                    # This file
```

---

## 🤝 Contributing

Please refer to [CONTRIBUTING.md](CONTRIBUTING.md) for contribution guidelines.

---

## 📄 License

MIT License - See [LICENSE](LICENSE) file for details.

---

**Last Updated**: July 4, 2026
