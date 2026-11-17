
# OfflineTrack

OfflineTrack is an offline-first family location-sharing application that allows users to share their location between authorized Android and Windows devices using Bluetooth Low Energy (BLE).

## Project Goals

- Share location without internet connectivity.
- Allow users to control location sharing.
- Connect Android and Windows devices using BLE.
- Store location history locally.
- Protect user privacy and device communication.

## Technology Stack

| Component | Technology |
|---|---|
| Android | Kotlin, Jetpack Compose |
| Architecture | MVVM |
| Local Database | Room |
| Windows | Python, PySide6 |
| Windows Database | SQLite |
| Communication | Bluetooth Low Energy |
| Protocol | JSON |

## Project Structure

```text
OfflineTrack/
├── android/          # Android application
├── windows/          # Windows desktop application
├── shared/
│   └── protocol/     # Shared communication protocol
├── docs/             # Project documentation
└── README.md
```

## Version 1.0 Scope

- Android location sharing.
- Android BLE advertising and GATT server.
- Windows BLE scanning and GATT client.
- Secure device authorization.
- Local location history.
- Start and stop sharing controls.

Android-to-Windows communication is the initial target. Android-to-Android support is planned for a later version.

## Important

- GPS obtains the device location.
- Bluetooth transfers location data between nearby devices.
- BLE communication has limited range.
- Version 1.0 does not require a cloud backend or internet connection.

## Project Status

Currently under development.
