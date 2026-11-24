
package com.offlinetrack.android.presentation.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// Represents the current state of the Home screen.
data class HomeUiState(
    val isSharing: Boolean = false,
    val isBluetoothConnected: Boolean = false,
    val lastLocationUpdate: String = "Not available"
)

// Manages Home screen state.
class HomeViewModel : ViewModel() {

    // Internal state that only this ViewModel can modify.
    private val _uiState = MutableStateFlow(HomeUiState())

    // Public read-only state observed by the UI.
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    // Starts or stops the sharing state.
    fun toggleSharing() {
        _uiState.update { currentState ->
            currentState.copy(
                isSharing = !currentState.isSharing
            )
        }
    }
}
