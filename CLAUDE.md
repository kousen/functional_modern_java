# Claude Development Documentation

This document contains important information for Claude AI assistant when working on this project.

## Project Overview

This is the source code repository for "Functional Modern Java" presentation examples. It's a Java project showcasing modern Java features and functional programming patterns, recently modernized with current tooling and testing frameworks.

## Build System & Dependencies

### Core Technologies
- **Language**: Java 21 (using Gradle toolchain)
- **Build Tool**: Gradle 8.14.2 (latest stable)
- **Testing**: JUnit 5.13.2 (fully migrated from JUnit 4)
- **CI**: GitHub Actions

### Key Dependencies
- `org.junit.jupiter:junit-jupiter` - Main testing framework
- `org.junit.platform:junit-platform-launcher` - Required for test execution
- `com.google.code.gson:gson` - JSON processing library

### Dependency Management
- Uses JUnit BOM for consistent version management
- No JUnit vintage engine (fully migrated to JUnit 5)

## Project Structure

```
src/
├── main/java/          # Main source code with Java examples
├── test/java/          # JUnit 5 test suite (16 test files)
gradle/
└── wrapper/           # Gradle wrapper files
```

## Recent Modernization Work

### Major Updates Completed
1. **Gradle Upgrade**: 7.6 → 8.14.2
2. **Java Version**: 11 → 21 (latest LTS with toolchain support)
3. **JUnit Management**: Added BOM for consistent versioning
4. **Build Modernization**: Updated GitHub Actions

### Testing Framework Status
- **All test files already use JUnit 5** (16 files)
- **Modern patterns in use**:
  - `assertThrows()` for exception testing
  - `@BeforeEach/@AfterEach` lifecycle methods
  - `@Disabled` for disabled tests
  - `org.junit.jupiter.api.Assertions.*` imports

## Common Development Tasks

### Running Tests
```bash
# All tests
./gradlew test

# Specific test class
./gradlew test --tests "http.JokeClientTest"

# With detailed output
./gradlew test --info
```

### Building
```bash
# Clean build
./gradlew clean build

# Just compile
./gradlew compileJava compileTestJava
```

## Important Notes for Claude

### When Working with Tests
- All tests use JUnit 5 - no JUnit 4 imports should be added
- Use `assertThrows()` for exception testing, not `@Test(expected = ...)`
- Use `@BeforeEach/@AfterEach` instead of `@Before/@After`
- Use `@Disabled` instead of `@Ignore`

### Code Patterns to Follow
- Java 21 features are available for build/test infrastructure
- Code examples maintain compatibility with modern Java patterns
- Use modern testing patterns (JUnit 5)
- Follow existing package structure and naming conventions

### Dependencies
- JUnit BOM manages version consistency
- Avoid adding junit-vintage-engine unless absolutely necessary

### GitHub Actions
- CI runs on Java 21
- Builds with `./gradlew build`
- All tests must pass for successful builds

## Known Issues/Considerations

### Test Execution
- All core functionality tests pass consistently
- Some deprecation warnings about `finalize()` method (expected with Java 21)

### Compatibility
- Project uses Java 21 for builds and runtime
- Modern Gradle version provides better performance and features
- JUnit 5 provides better test organization and modern features

## Files to Monitor

### Critical Configuration Files
- `build.gradle` - Main build configuration
- `gradle/wrapper/gradle-wrapper.properties` - Gradle version
- `.github/workflows/gradle.yml` - CI configuration

### Test Directory Structure
- All test files in `src/test/java/` use JUnit 5
- Test organization follows main source package structure
- Both unit tests and integration examples present

## Test Files Inventory

The project contains 16 test files covering:
- `collections/` - Immutable collections tests
- `generics/` - Generic type safety tests
- `got/` - Member DAO tests
- `http/` - HTTP client tests (Astro, Joke APIs)
- `interfaces/` - Interface enhancement tests
- `lambdas/` - Functional interface tests
- `lvti/` - Local variable type inference tests
- `optional/` - Optional handling tests
- `streams/` - Stream API exercises and tests

This documentation helps ensure consistent development practices and maintains the project's modernized state.