
package com.offlinetrack.android.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onToggleSharing: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "OfflineTrack",
            style = MaterialTheme.typography.headlineMedium
        )

        Card {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Location Sharing")
                Text(
                    if (uiState.isSharing) "Sharing active" else "Not sharing"
                )

                Button(onClick = onToggleSharing) {
                    Text(if (uiState.isSharing) "Stop Sharing" else "Start Sharing")
                }
            }
        }

        Card {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Bluetooth")
                Text(
                    if (uiState.isBluetoothConnected) "Connected" else "Disconnected"
                )
            }
        }

        Card {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Last Location Update")
                Text(uiState.lastLocationUpdate)
            }
        }
    }
}
