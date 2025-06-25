# Functional Modern Java

Source code and examples from the "Functional Modern Java" presentation, showcasing modern Java features and functional programming patterns.

## Requirements

- **Java 21** (LTS) or higher
- **Gradle 8.14.2** or higher (wrapper included)

## Building and Running

### Build the project
```bash
./gradlew build
```

### Run tests
```bash
./gradlew test
```

### Clean build
```bash
./gradlew clean build
```

## Project Structure

```
src/
├── main/java/          # Main source code with Java examples
├── test/java/          # JUnit 5 test suite
```

## Technology Stack

- **Language**: Java 21 (using Gradle toolchain)
- **Build Tool**: Gradle 8.14.2
- **Testing**: JUnit 5.13.2
- **CI**: GitHub Actions

## Topics Covered

This project demonstrates modern Java features including:
- Lambda expressions and functional interfaces
- Stream API and operations
- Optional handling
- Modern collection utilities
- HTTP client examples
- Local variable type inference (var)
- Interface enhancements
- Generics and type safety

## Contributing

All tests use JUnit 5. When adding new tests, follow the existing patterns and ensure compatibility with Java 21.
