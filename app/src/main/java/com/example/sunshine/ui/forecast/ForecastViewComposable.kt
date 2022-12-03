package com.example.sunshine.ui.forecast

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sunshine.domain.weather.WeatherInfo
import com.example.sunshine.ui.forecast.ForecastViewModel.ViewState
import com.example.sunshine.ui.theme.SunshineTheme
import timber.log.Timber

@Composable
fun ForecastViewComposable(viewModel: ForecastViewModel) {
    val state by viewModel.state.collectAsState()

    ForecastView(state = state)
}

@Composable
fun ForecastView(state: ViewState) {
    when (state) {
        ViewState.Loading -> LoadingScreen()
        is ViewState.Success -> {
            val data = state.data
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                SunshineToolbar {
                    Timber.d("To implement in the next version")
                }
                data?.currentWeatherData?.let { data ->
                    TodayWeatherItem(data = data)
                }
                data?.weatherDataPerDay?.flatMap { it.value }?.forEach { data ->
                    ForecastItem(data = data) {
                        Timber.d("To implement in the next version")
                    }
                }
            }
        }
        is ViewState.Error -> Text(text = "${state.exception}")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SunshineTheme {
        ForecastView(
            state = ViewState.Success(
                data = WeatherInfo(emptyMap(), null)
            )
        )
    }
}
