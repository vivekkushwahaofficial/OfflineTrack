
# OfflineTrack Architecture

## 1. Overview

OfflineTrack is an offline-first location-sharing application that supports communication between Android and Windows devices using Bluetooth Low Energy (BLE).

The system has three main parts:

- Android App: Collects device location and shares it through BLE.
- Windows App: Receives location data and stores it locally.
- Shared Protocol: Defines the communication format between devices.

## 2. System Architecture

```text
              Android Device A
             (BLE GATT Server)
                    |
                    | Bluetooth Low Energy
                    |
          +---------+---------+
          |                   |
          v                   v
   Android Device B       Windows PC
   (BLE GATT Client)   (BLE GATT Client)
```

Either Android device can act as a GATT Server or Client when required.

## 3. Android Application

- Kotlin and Jetpack Compose for the user interface.
- MVVM for presentation logic.
- Android Location APIs for GPS-based location.
- BLE GATT Server and Client for communication.
- Room for local storage.
- Hilt for dependency injection.
- Kotlin Coroutines and Flow for asynchronous operations.

## 4. Windows Application

- Python and PySide6 for the desktop interface.
- Bleak for Bluetooth communication.
- SQLite for local storage.
- pytest for automated testing.

## 5. Communication Flow

1. User explicitly starts location sharing.
2. Android obtains the device location.
3. Android creates a versioned JSON message.
4. The Android device makes the data available through BLE GATT.
5. The receiving device discovers and connects to the sender.
6. The receiver reads and validates the message.
7. The receiver stores the received location locally.
8. The user can stop sharing at any time.

## 6. Security and Privacy

- Location sharing requires explicit user consent.
- Only authorized devices can exchange location data.
- Messages must be authenticated and protected against replay.
- Users can stop sharing at any time.
- Users can export or delete locally stored location data.
- No hidden or unauthorized tracking.

## 7. Version 1.0 Scope

- Android-to-Android communication.
- Android-to-Windows communication.
- Android supports BLE GATT Server and Client roles.
- Windows initially supports the BLE GATT Client role.
- All devices use the same versioned JSON protocol.
- Location history is stored locally.
- No cloud backend or internet-based synchronization.

## 8. Technical Constraints

- GPS obtains the device location; BLE transfers the location data.
- BLE communication has limited range.
- Android BLE background operation is subject to Android platform restrictions.
- Actual device compatibility must be verified through testing.
