# CLAUDE.md

## Repository Overview

This is a comprehensive **Learning Technical** repository containing coding interview problems, algorithms, data structures, and system design resources from multiple platforms and educational sources.

## Key Information

- **Main Language**: Java (with Gradle build system)
- **Additional Languages**: Python, JavaScript
- **Testing**: JUnit 5 with JUnit 4 vintage support
- **Build Tool**: Gradle with Java 19 support
- **Coverage**: Jacoco for code coverage
- **CI/CD**: GitHub Actions, CircleCI integration

## Repository Structure

### Major Sections

- **src/**: Main source code organized by platform/resource
  - **LeetCode/**: LeetCode problems and solutions
  - **HackerRank/**: HackerRank coding challenges
  - **CrackingTheCodingInterview/**: Problems from the famous interview book
  - **EducativeIo/**: Courses from Educative.io (Grokking patterns)
  - **ByteByByteGo/**: System design interview content
  - **GeeksForGeeks/**: Algorithm and data structure problems
  - **InterviewBit/**, **Pramp/**, **InterviewCake/**: Various interview platforms
  - **_notes/**: Study notes from technical books

### Key Files

- **build.gradle**: Java build configuration with JUnit 5, Jacoco coverage
- **requirements.txt**: Python dependencies
- **metadata.json**: Project metadata
- **website/**: Static website for problem browsing

## Development Commands

### Testing

```bash
# Run all tests
./gradlew test

# Run tests with coverage
./gradlew jacocoTestReport
```

### Build

```bash
# Clean build
./gradlew clean build

# Run specific test
./gradlew test --tests "ClassName"
```

### Python Scripts

```bash
# Get problems count
python scripts/get_problems_count.py

# Run Python unit tests  
python scripts/run_unit_tests.py
```

## Project Features

- **Multi-platform coverage**: Problems from 20+ coding platforms
- **Multiple languages**: Java, Python, JavaScript implementations
- **Comprehensive testing**: Unit tests for most solutions
- **System design**: Notes and problems on distributed systems
- **Book resources**: Implementation of problems from technical books
- **CI/CD pipeline**: Automated testing and code quality checks

## Usage Notes

1. **Problem Organization**: Each problem typically includes:
   - `readme.md`: Problem description and approach
   - `metadata.json`: Problem metadata
   - Language-specific solution files
   - Test files

2. **Learning Focus**: Repository prioritizes understanding over just solving
3. **References**: Original solution references provided where applicable
4. **Continuous Integration**: All code changes are tested automatically

## Contributing

See `.github/CONTRIBUTING.md` for contribution guidelines.

---

*This repository serves as a comprehensive resource for technical interview preparation and computer science learning.*
