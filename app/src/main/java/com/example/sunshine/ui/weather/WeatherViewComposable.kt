package com.example.sunshine.ui.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sunshine.domain.weather.WeatherData
import com.example.sunshine.ui.theme.DarkBlue
import com.example.sunshine.ui.theme.DeepBlue
import com.example.sunshine.ui.theme.SunshineTheme
import com.example.sunshine.ui.weather.WeatherViewModel.ViewState
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import java.time.LocalDateTime

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
        viewModel.getForecast()

        WeatherView(viewState = state)
    } else {
        Column {
            val allPermissionsRevoked =
                locationPermissionsState.permissions.size ==
                    locationPermissionsState.revokedPermissions.size

            val textToShow = if (!allPermissionsRevoked) {
                // If not all the permissions are revoked, it's because the user accepted the COARSE
                // location permission, but not the FINE one.
                "Yay! Thanks for letting me access your approximate location. " +
                    "But you know what would be great? If you allow me to know where you " +
                    "exactly are. Thank you!"
            } else if (locationPermissionsState.shouldShowRationale) {
                // Both location permissions have been denied
                "Getting your exact location is important for this app. " +
                    "Please grant us fine location. Thank you :D"
            } else {
                // First time the user sees this feature or the user doesn't want to be asked again
                "This feature requires location permission"
            }

            val buttonText = if (!allPermissionsRevoked) {
                "Allow precise location"
            } else {
                "Request permissions"
            }

            Text(text = textToShow)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                locationPermissionsState.launchMultiplePermissionRequest()
            }) {
                Text(buttonText)
            }
        }
    }
}

@Composable
fun WeatherView(
    modifier: Modifier = Modifier,
    viewState: ViewState,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(DarkBlue)
    ) {
        when (viewState) {
            ViewState.Loading -> CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
            is ViewState.WeatherInfo -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    viewState.currentWeatherData?.let { weatherData ->
                        WeatherCard(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp),
                            data = weatherData,
                            backgroundColor = DeepBlue
                        )
                    }
                    for (dailyData in viewState.weatherDataPerDay?.values ?: emptyList()) {
                        Spacer(modifier = Modifier.height(16.dp))
                        WeatherForecast(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                            data = dailyData
                        )
                    }
                    Spacer(modifier = Modifier.height(72.dp))
                }
            }
            is ViewState.Error -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(modifier = Modifier.padding(16.dp), text = "${viewState.exception}")

                    viewState.currentWeatherData?.let { weatherData ->
                        WeatherCard(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp),
                            data = weatherData,
                            backgroundColor = DeepBlue
                        )
                    }
                    for (dailyData in viewState.weatherDataPerDay?.values ?: emptyList()) {
                        Spacer(modifier = Modifier.height(16.dp))
                        WeatherForecast(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                            data = dailyData
                        )
                    }
                    Spacer(modifier = Modifier.height(72.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Preview(showBackground = true)
@Composable
fun PreviewWeatherView() {
    val data = WeatherData(
        id = 0,
        time = LocalDateTime.now(),
        weatherCode = 0,
        pressure = 0.0,
        temperatureCelsius = 0.0,
        windSpeed = 0.0,
        humidity = 0,
    )
    SunshineTheme {
        WeatherView(
            viewState = ViewState.WeatherInfo(
                weatherDataPerDay = mapOf(0 to listOf(data, data, data)),
                currentWeatherData = data
            ),
        )
    }
}
