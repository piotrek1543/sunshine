package com.example.sunshine.ui.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunshine.domain.repository.ForecastRepository
import com.example.sunshine.domain.util.Resource
import com.example.sunshine.domain.weather.WeatherInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: ForecastRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<ViewState>(ViewState.Loading)
    val state = _state.asStateFlow()

    init {
        getForecast()
    }

    private fun getForecast() {
        viewModelScope.launch {
            _state.emit(ViewState.Loading)
            when (
                val result = repository.getWeatherData(
                    lat = DEFAULT_LOCATION_LATITUDE,
                    long = DEFAULT_LOCATION_LONGITUDE,
                )
            ) {
                is Resource.Success -> {
                    _state.emit(ViewState.Success(result.data))
                }
                is Resource.Error -> {
                    _state.emit(ViewState.Error(Exception(result.message)))
                }
            }
        }
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class Success(
            val data: WeatherInfo?,
        ) : ViewState()

        data class Error(
            val exception: Exception,
        ) : ViewState()
    }

    companion object {
        // todo - Replace it with LocationTracker
        private const val DEFAULT_LOCATION_LATITUDE = 52.40692
        private const val DEFAULT_LOCATION_LONGITUDE = 16.92993
    }
}
