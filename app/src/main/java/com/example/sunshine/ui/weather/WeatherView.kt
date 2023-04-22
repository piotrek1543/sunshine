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
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sunshine.domain.weather.WeatherData
import com.example.sunshine.ui.theme.DarkBlue
import com.example.sunshine.ui.theme.SunshineTheme
import com.example.sunshine.ui.weather.WeatherViewModel.ViewState
import java.time.LocalDateTime

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
                ) {
                    viewState.currentWeatherData?.let { weatherData ->
                        CurrentWeatherInfo(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp),
                            currentData = weatherData,
                        )
                    }
                    /*for (dailyData in viewState.weatherDataPerDay?.values ?: emptyList()) {
                        Spacer(modifier = Modifier.height(16.dp))
                        WeatherForecast(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                            data = dailyData
                        )
                    }
                    Spacer(modifier = Modifier.height(72.dp))*/
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
                        CurrentWeatherInfo(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp),
                            currentData = weatherData,
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
