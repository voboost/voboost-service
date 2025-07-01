# Voboost Service

An Android background service for Voyah vehicles (Free, Dreamer) that applies configuration settings to vehicle systems with reliable operation and seamless integration with the voboost-config library.

## Overview

Voboost Service provides a robust Android background service that monitors configuration changes and applies them to Voyah vehicle systems. Built with Kotlin/Android and integrated with the voboost-config library, it ensures reliable configuration management and vehicle system integration.

## Features

- **Background Service**: Reliable Android foreground service operation
- **Configuration Monitoring**: Real-time monitoring of configuration file changes
- **Vehicle System Integration**: Direct integration with Voyah vehicle APIs
- **Model-Specific Support**: Tailored integration for Voyah Free and Dreamer
- **Error Recovery**: Automatic rollback and error handling
- **System Health Monitoring**: Continuous monitoring of vehicle system state
- **Configuration Validation**: Real-time validation using voboost-config
- **Backup Management**: Automatic backup before configuration changes

## Target Platform

- **Android Versions**: Android 9 and Android 11
- **Vehicle Models**: Voyah Free, Voyah Dreamer
- **Hardware**: Automotive-grade Android hardware in Voyah vehicles

## Technology Stack

- **Language**: Kotlin/Android
- **Service Framework**: Android Services with foreground operation
- **Configuration Library**: voboost-config
- **Architecture**: Service-oriented with Android Architecture Components
- **Build System**: Gradle with Kotlin DSL
- **Code Style**: Unified Voboost code style

## Project Structure

```
voboost-service/
├── app/src/main/kotlin/      # Main Android service source
├── app/src/test/kotlin/      # Unit tests
├── app/src/androidTest/      # Android instrumentation tests
├── app/src/main/res/         # Android resources
├── memory-bank/              # Project documentation
├── .clinerules              # Project-specific rules
├── .editorconfig            # Code style configuration (symlink)
└── build.gradle.kts         # Build configuration
```

## Development Setup

### Prerequisites

- Android Studio Arctic Fox or newer
- JDK 11 or higher
- Android SDK with API levels 28 (Android 9) and 30 (Android 11)
- Voyah vehicle hardware or emulator setup

### Building

```bash
./gradlew assembleDebug
```

### Installing

```bash
./gradlew installDebug
```

### Testing

```bash
./gradlew test
./gradlew connectedAndroidTest
```

## Service Architecture

### Core Components

- **VoboostService**: Main Android foreground service
- **ConfigurationMonitor**: File observer for configuration changes
- **VehicleConfigProcessor**: Applies configurations to vehicle systems
- **VoyahIntegrator**: Vehicle-specific system integration
- **ErrorHandler**: Manages errors and rollback procedures

### Service Features

- **Foreground Service**: Ensures reliable background operation
- **Service Binding**: Communication interface for main app
- **Broadcast Receivers**: System event handling
- **Work Manager**: Scheduled configuration tasks
- **Notification Management**: User feedback and status updates

## Integration with voboost-config

This service integrates with the voboost-config library for:

- Configuration file parsing and validation
- YAML structure management for vehicle settings
- Error handling and reporting
- Configuration diff utilities for system changes

## Vehicle System Integration

### Voyah Integration
- **Model Detection**: Automatic detection of Free vs Dreamer models
- **System APIs**: Integration with Voyah vehicle system APIs
- **State Monitoring**: Real-time vehicle system state monitoring
- **Configuration Application**: Direct application to vehicle systems

### Configuration Categories
- **Performance**: Engine and transmission settings
- **Comfort**: Climate and interior preferences
- **Safety**: Driver assistance and safety systems
- **Connectivity**: Infotainment and network settings
- **Energy**: Battery and charging management

## Service Lifecycle

1. **Service Start**: Initialize service and register observers
2. **Configuration Monitoring**: Watch for configuration file changes
3. **Validation**: Validate changes using voboost-config
4. **Backup Creation**: Create system state backup
5. **Application**: Apply configuration to vehicle systems
6. **Verification**: Verify successful application
7. **Error Handling**: Handle errors and rollback if needed
8. **Notification**: Update status and notify systems

## Code Style

This project follows the unified Voboost code style defined in `../voboost-codestyle/`. Key rules:

- All code, comments, and documentation in English
- Kotlin code style with 4-space indentation
- Result<T> pattern for error handling
- KDoc comments for public APIs
- Files must end with blank line

## Contributing

1. Follow the code style guidelines
2. Write comprehensive tests (unit and instrumentation)
3. Test on target Android versions (9, 11)
4. Update documentation as needed
5. Ensure all tests pass before committing

## Related Projects

- [voboost-config](../voboost-config/): Core configuration library
- [voboost](../voboost/): Android app for vehicle configuration interface
- [voboost-codestyle](../voboost-codestyle/): Unified code style rules

## License

[License information to be added]