package com.example.sunshine.ui.weather

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun WeatherViewComposable(viewModel: WeatherViewModel) {
    val locationPermissionsState = rememberMultiplePermissionsState(
        listOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
        )
    )
    val state by viewModel.state.collectAsState()

    if (locationPermissionsState.allPermissionsGranted) {
        WeatherView(viewState = state)
    } else {
        LocationPermissionRequestView(locationPermissionsState) {
            locationPermissionsState.launchMultiplePermissionRequest()
        }
    }
}
