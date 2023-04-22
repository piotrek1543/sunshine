package com.example.sunshine.ui.weather

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunshine.domain.location.LocationTracker
import com.example.sunshine.domain.repository.ForecastRepository
import com.example.sunshine.domain.util.Resource
import com.example.sunshine.domain.weather.WeatherData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: ForecastRepository,
    private val locationTracker: LocationTracker,
) : ViewModel() {

    private val _state = MutableStateFlow<ViewState>(ViewState.Loading)
    val state = _state.asStateFlow()

    fun getForecast() {
        viewModelScope.launch {
            _state.emit(ViewState.Loading)
            val now = LocalDateTime.now()
            val location = locationTracker.getCurrentLocation() ?: Location("").apply {
                longitude = DEFAULT_LOCATION_LONGITUDE
                latitude = DEFAULT_LOCATION_LATITUDE
            }
            val result = repository.getWeatherData(
                lat = location.latitude,
                long = location.longitude,
            )
            when (result) {
                is Resource.Success -> {
                    val currentWeatherData = getCurrentWeatherData(result.data, now)
                    val weatherDataPerDay = getWeatherDataPerDay(result.data)

                    _state.emit(
                        ViewState.WeatherInfo(
                            weatherDataPerDay = weatherDataPerDay,
                            currentWeatherData = currentWeatherData
                        )
                    )
                }
                is Resource.Error -> {
                    val currentWeatherData = getCurrentWeatherData(result.data, now)
                    val weatherDataPerDay = getWeatherDataPerDay(result.data)
                    _state.emit(
                        ViewState.Error(
                            currentWeatherData = currentWeatherData,
                            weatherDataPerDay = weatherDataPerDay,
                            exception = Exception(result.message)
                        )
                    )
                }
            }
        }
    }

    private fun getCurrentWeatherData(
        data: List<WeatherData>?,
        now: LocalDateTime
    ) = data?.find {
        val hour = if (now.minute < DEFAULT_MINUTE_TO_COMPARE) now.hour else now.hour + 1
        it.time?.hour == hour
    }

    private fun getWeatherDataPerDay(data: List<WeatherData>?) =
        data?.groupBy { (index) -> index / DEFAULT_DAILY_HOURS_COUNT }

    sealed class ViewState {
        object Loading : ViewState()
        data class WeatherInfo(
            val weatherDataPerDay: Map<Int, List<WeatherData>>?,
            val currentWeatherData: WeatherData?,
        ) : ViewState()

        data class Error(
            val exception: Exception,
            val weatherDataPerDay: Map<Int, List<WeatherData>>? = null,
            val currentWeatherData: WeatherData? = null,
        ) : ViewState()
    }

    companion object {
        private const val DEFAULT_LOCATION_LATITUDE = 52.40692
        private const val DEFAULT_LOCATION_LONGITUDE = 16.92993
        private const val DEFAULT_MINUTE_TO_COMPARE = 30
        private const val DEFAULT_DAILY_HOURS_COUNT = 24
    }
}
