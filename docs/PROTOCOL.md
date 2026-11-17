
# OfflineTrack Communication Protocol

## 1. Overview

OfflineTrack uses Bluetooth Low Energy (BLE) to exchange location data between authorized devices.

The initial communication format is versioned JSON.

## 2. Protocol Information

- Protocol Name: OfflineTrack Protocol
- Initial Version: 1.0
- Transport: Bluetooth Low Energy (BLE)
- Data Format: JSON
- Communication: BLE GATT

## 3. Location Message

Example location message:

```json
{
  "protocolVersion": 1,
  "messageId": "unique-message-id",
  "messageType": "LOCATION_UPDATE",
  "senderDeviceId": "android-device-001",
  "timestamp": 1795000000000,
  "payload": {
    "latitude": 25.5941,
    "longitude": 85.1376,
    "accuracyMeters": 10.5
  }
}
```

## 4. Field Definitions

| Field | Description |
|---|---|
| protocolVersion | Protocol version |
| messageId | Unique message identifier |
| messageType | Type of message |
| senderDeviceId | Sender device identifier |
| timestamp | Message creation time in Unix milliseconds |
| latitude | Latitude coordinate |
| longitude | Longitude coordinate |
| accuracyMeters | Location accuracy in meters |

## 5. Message Types

- LOCATION_UPDATE: Shares a location update.
- DEVICE_INFO: Shares basic device information.
- ACKNOWLEDGEMENT: Confirms message reception.
- ERROR: Reports a communication error.

## 6. Validation Rules

- Reject unsupported protocol versions.
- Reject missing or invalid required fields.
- Latitude must be between -90 and 90.
- Longitude must be between -180 and 180.
- Validate timestamps and message identifiers.
- Reject duplicate or replayed messages.
- Authenticate the sender before accepting location data.

## 7. BLE Communication

- Android devices can operate as GATT Server or Client.
- Windows initially operates as a GATT Client.
- Location messages are exchanged through GATT characteristics.
- Large messages must be split into supported BLE-sized chunks and reassembled safely.
- BLE service and characteristic UUIDs will be defined before implementation.

## 8. Security

- Only authorized devices can exchange location data.
- Messages must have integrity and authenticity protection.
- Replay protection must be implemented.
- Sensitive data must not be logged unnecessarily.

## 9. Compatibility

All supported platforms must follow the same protocol version and message definitions.

Protocol changes must maintain compatibility or introduce a new version.
