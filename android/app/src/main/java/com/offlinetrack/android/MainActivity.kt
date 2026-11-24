
package com.offlinetrack.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.offlinetrack.android.presentation.home.HomeScreen
import com.offlinetrack.android.presentation.home.HomeViewModel
import com.offlinetrack.android.ui.theme.OfflineTrackTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            OfflineTrackTheme {
                val homeViewModel: HomeViewModel = viewModel()
                val uiState by homeViewModel.uiState.collectAsState()

                HomeScreen(
                    uiState = uiState,
                    onToggleSharing = homeViewModel::toggleSharing
                )
            }
        }
    }
}
