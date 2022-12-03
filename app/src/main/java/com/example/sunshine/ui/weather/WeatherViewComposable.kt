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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sunshine.domain.weather.WeatherInfo
import com.example.sunshine.ui.theme.DarkBlue
import com.example.sunshine.ui.theme.DeepBlue
import com.example.sunshine.ui.theme.SunshineTheme
import com.example.sunshine.ui.weather.WeatherViewModel.ViewState

@Composable
fun WeatherViewComposable(viewModel: WeatherViewModel) {
    val state by viewModel.state.collectAsState()

    WeatherView(state = state)
}

@Composable
fun WeatherView(
    modifier: Modifier = Modifier,
    state: ViewState,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(DarkBlue)
    ) {
        when (state) {
            ViewState.Loading -> CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
            is ViewState.Success -> {
                val data = state.data
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    data?.currentWeatherData?.let { weatherData ->
                        WeatherCard(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp),
                            data = weatherData,
                            backgroundColor = DeepBlue
                        )
                    }
                    for (dailyData in data?.weatherDataPerDay?.values ?: emptyList()) {
                        Spacer(modifier = Modifier.height(16.dp))
                        WeatherForecast(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                            data = dailyData
                        )
                    }
                    Spacer(modifier = Modifier.height(72.dp))
                }
            }
            is ViewState.Error -> Text(text = "${state.exception}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SunshineTheme {
        WeatherView(
            state = ViewState.Success(
                data = WeatherInfo(emptyMap(), null)
            )
        )
    }
}
