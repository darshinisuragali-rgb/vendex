# Vendex Development Guide

## 🛠️ Development Setup

### Prerequisites

- **Node.js**: v18.x or higher
- **Java**: JDK 17 or higher
- **Maven**: 3.8.x or higher
- **Docker**: Latest version
- **PostgreSQL**: 14 or higher
- **Git**: 2.30.x or higher

### Environment Setup

#### 1. Clone Repository

```bash
git clone https://github.com/darshinisuragali-rgb/vendex.git
cd vendex
```

#### 2. Set Up Environment Variables

```bash
cp .env.example .env
```

#### 3. Start Development

```bash
# Terminal 1: Frontend
cd frontend
npm install
npm start

# Terminal 2: Backend
cd backend
mvn clean install
mvn spring-boot:run
```

---

## 📝 Code Standards

### Frontend (React/JavaScript)

```javascript
// ✅ Good: Named exports, meaningful names
export const UserComponent = ({ userId }) => {
  return <div>User: {userId}</div>;
};
```

### Backend (Java/Spring Boot)

```java
// ✅ Good: Clear naming, proper error handling
@Service
public class UserService {
    public UserDTO createUser(UserCreateRequest request) {
        validateUserRequest(request);
        User user = new User(request);
        userRepository.save(user);
        return UserMapper.toDTO(user);
    }
}
```

---

## 🔄 Git Workflow

### Branch Naming

```
feature/feature-name          # New features
bugfix/bug-description        # Bug fixes
hotfix/critical-issue         # Production hotfixes
```

### Commit Message Format

```
<type>(<scope>): <subject>

<body>

<footer>
```

**Types**: feat, fix, docs, style, refactor, perf, test, chore

---

## ✅ Testing Requirements

### Coverage Targets

- **Minimum**: 80% overall code coverage
- **Controllers**: 90% coverage
- **Services**: 90% coverage

### Running Tests

```bash
# Frontend
cd frontend
npm test

# Backend
cd backend
mvn test
```

---

**Last Updated**: July 4, 2026
