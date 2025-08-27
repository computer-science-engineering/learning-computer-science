# Learning Computer Science

<div align="center">

![Learning Computer Science Logo](https://github.com/manastalukdar/learning-technical/blob/main/resources/images/logo/Logo%20LCS%20color/logo%20LCS%20color%20low%20res.png?raw=true)

**A comprehensive repository for mastering data structures, algorithms, and system design through hands-on practice**

[![GitHub Actions](https://github.com/manastalukdar/learning-technical/workflows/build-test/badge.svg)](https://github.com/manastalukdar/learning-technical/actions)
[![GitHub Super-Linter](https://github.com/manastalukdar/learning-technical/workflows/Lint%20Code%20Base/badge.svg)](https://github.com/manastalukdar/learning-technical/actions)
[![codecov](https://codecov.io/gh/manastalukdar/learning-technical/branch/main/graph/badge.svg)](https://codecov.io/gh/manastalukdar/learning-technical)

</div>

## 📚 Table of Contents

- [Overview](#-overview)
- [🚀 Quick Start](#-quick-start)
- [🏗️ Repository Structure](#️-repository-structure)
- [💻 Development](#-development)
- [🧪 Testing](#-testing)
- [🤝 Contributing](#-contributing)
- [📊 Project Stats](#-project-stats)
- [🔗 Resources](#-resources)
- [📝 License](#-license)

## 🎯 Overview

This repository is a comprehensive learning resource for computer science fundamentals, containing **thousands of coding problems** and system design concepts from top interview platforms and educational resources. Whether you're preparing for technical interviews or strengthening your programming foundation, this repository provides structured practice across multiple programming languages.

### ✨ Key Features

- 🎯 **20+ Coding Platforms**: LeetCode, HackerRank, InterviewBit, and more
- 🏗️ **System Design**: Real-world architecture problems and solutions
- 📚 **Book Solutions**: Implementation from "Cracking the Coding Interview" and other technical books
- 🌐 **Multi-Language Support**: Java, Python, JavaScript implementations
- 🧪 **Comprehensive Testing**: Unit tests for all solutions
- 📊 **Progress Tracking**: Automated problem counting and statistics
- 🔄 **CI/CD Pipeline**: Automated testing and code quality checks

## 🚀 Quick Start

### Prerequisites

- **Java**: OpenJDK 19+ ([Download here](https://adoptium.net))
- **Python**: 3.x ([Download here](https://python.org))
- **IDE**: [VS Code](https://code.visualstudio.com/) (recommended)

### Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/manastalukdar/learning-technical.git
   cd learning-technical
   ```

2. **Run tests to verify setup**:

   ```bash
   # Java tests
   ./gradlew test
   
   # Python tests
   python scripts/run_unit_tests.py
   ```

3. **Open in VS Code** (recommended):

   ```bash
   code .
   ```

### Usage Examples

**Run specific problem tests**:

```bash
./gradlew test --tests "*TwoSum*"
```

**Generate coverage report**:

```bash
./gradlew jacocoTestReport
```

**Count problems in repository**:

```bash
python scripts/get_problems_count.py
```

## 🏗️ Repository Structure

```plaintext
learning-technical/
├── 📁 src/
│   ├── 🎯 LeetCode/              # LeetCode problems & solutions
│   ├── 🏆 HackerRank/            # HackerRank challenges
│   ├── 📖 CrackingTheCodingInterview/  # Book implementations
│   ├── 🎓 EducativeIo/           # Grokking coding patterns
│   ├── 🏗️ ByteByByteGo/          # System design content
│   ├── 💡 InterviewBit/          # Interview preparation
│   └── 📝 _notes/               # Study notes from tech books
├── 🧪 scripts/                  # Automation and testing scripts
├── 🌐 website/                  # Problem browsing interface
├── 📋 build.gradle              # Java build configuration
└── 📊 requirements.txt          # Python dependencies
```

### Problem Organization

Each problem typically includes:

- 📄 `readme.md` - Problem description and approach
- ⚙️ `metadata.json` - Problem metadata and tags
- 💻 Solution files in multiple languages
- ✅ Comprehensive unit tests

## 💻 Development

### Tech Stack

| Technology    | Version | Purpose                                    |
| ------------- | ------- | ------------------------------------------ |
| ☕ **Java**    | 19+     | Primary language for algorithms            |
| 🐍 **Python**  | 3.x     | Secondary implementation language          |
| 📦 **Gradle**  | Latest  | Build automation and dependency management |
| 🧪 **JUnit 5** | Latest  | Java testing framework                     |
| 📊 **JaCoCo**  | Latest  | Code coverage analysis                     |
| 🔧 **VS Code** | Latest  | Recommended development environment        |

### Development Workflow

1. **Create a new problem solution**:

   ```bash
   # Navigate to appropriate platform folder
   cd src/LeetCode/src/Problems/P1_P100/P1_TwoSum/
   
   # Create solution and test files
   touch Java/Solution.java Java/SolutionTest.java
   ```

2. **Run tests during development**:

   ```bash
   # Run all tests
   ./gradlew test
   
   # Run specific test
   ./gradlew test --tests "SolutionTest"
   ```

3. **Check code coverage**:

   ```bash
   ./gradlew jacocoTestReport
   # View report at build/reports/jacoco/html/index.html
   ```

## 🧪 Testing

### Running Tests

**Java Tests** (JUnit 5):

```bash
# Run all Java tests
./gradlew test

# Run tests with verbose output
./gradlew test --info

# Run specific test class
./gradlew test --tests "*TwoSum*"
```

**Python Tests**:

```bash
# Run all Python tests
python scripts/run_unit_tests.py

# Run individual test file
python -m pytest src/LeetCode/Python/test_solution.py
```

**Coverage Reports**:

```bash
# Generate Java coverage report
./gradlew jacocoTestReport

# View HTML report
open build/reports/jacoco/html/index.html
```

### Continuous Integration

All code changes are automatically tested using:

- ✅ **GitHub Actions**: Build and test automation
- 🔍 **Super Linter**: Code quality and style checks
- 📊 **CodeCov**: Coverage reporting
- 🎯 **Multiple OS Testing**: Linux, Windows, macOS

## 🤝 Contributing

We welcome contributions! Here's how to get started:

### Quick Contribution Guide

1. **Fork the repository**
2. **Create a feature branch**: `git checkout -b feature/new-problem`
3. **Add your solution** with tests
4. **Run tests**: `./gradlew test`
5. **Submit a Pull Request**

### Contribution Guidelines

- ✅ Include comprehensive test coverage
- 📝 Add clear problem descriptions
- 🏷️ Update metadata.json files
- 🎯 Follow existing code organization
- 📋 Reference original problem sources

**Detailed guidelines**: [Contributing Guide](./.github/CONTRIBUTING.md)

## 📊 Project Stats

- 🎯 **20+ Coding Platforms** covered
- 📚 **1000+ Problems** implemented
- 🌐 **3 Programming Languages** (Java, Python, JavaScript)
- 🏗️ **System Design** problems included
- ✅ **Comprehensive Test Coverage**
- 🔄 **Active Maintenance** and updates

## 🔗 Resources

### 🌐 External Links

- 🔍 [**Sourcegraph**](https://sourcegraph.com/github.com/manastalukdar/learning-technical/) - Code exploration
- 💬 [**Discord Community**](https://discord.gg/bv5FU8t) - Join our learning community
- 📊 [**GitHub Projects**](https://github.com/manastalukdar/learning-technical/projects) - Project management

### 📚 Documentation

| Document                                                             | Purpose                       |
| -------------------------------------------------------------------- | ----------------------------- |
| [📋 Requirements](./documentation/development/requirements.md)        | Development environment setup |
| [🏗️ Architecture](./documentation/development/design-architecture.md) | System design and structure   |
| [🔄 CI/CD](./documentation/development/ci-cd.md)                      | Build and deployment pipeline |
| [📊 Metadata](./documentation/project/metadata.md)                    | Project statistics and badges |

## ⚠️ Important Notes

> **Learning Philosophy**: This repository prioritizes understanding over original problem-solving. Solutions may reference existing implementations to accelerate learning. All sources are properly attributed.

> **Problem Uniqueness**: Some problems appear across multiple platforms. We're developing a [web interface](https://github.com/manastalukdar/manastalukdar.github.io/projects/2) to filter and display unique problem instances.

## 📝 License

This project is licensed under the **MIT License** - see the [LICENSE](./LICENSE) file for details.

---

<div align="center">

**⭐ Star this repository if it helps you learn!**

[Report Bug](https://github.com/manastalukdar/learning-technical/issues) • [Request Feature](https://github.com/manastalukdar/learning-technical/issues)

</div>
