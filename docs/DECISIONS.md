
# OfflineTrack Technical Decisions

This document records the main technical decisions for OfflineTrack v1.0.


## 1. Technology Stack

- Android: Kotlin
- Android UI: Jetpack Compose
- Android Architecture: MVVM
- Android Database: Room
- Windows: Python
- Windows UI: PySide6
- Windows Database: SQLite
- Bluetooth: BLE
- Communication Format: Versioned JSON
- Dependency Injection: Hilt


## 2. Architecture

- Use separate Android and Windows applications.
- Keep business logic separate from UI and hardware communication.
- Use reusable BLE communication components.
- Maintain one shared protocol for all supported platforms.

## 3. Communication

- Use BLE GATT for device communication.
- Android supports Server and Client roles.
- Windows initially supports the Client role.
- Keep communication offline without a cloud backend.

## 4. Security and Privacy

- Require explicit user consent before sharing location.
- Allow users to stop sharing at any time.
- Authorize devices before accepting location data.
- Protect messages against modification and replay.

## 5. Project Constraints

- Development budget: ₹0.
- Initial target: Android-to-Android and Android-to-Windows.
- No cloud services in v1.0.
- Keep the architecture extensible for future features.
