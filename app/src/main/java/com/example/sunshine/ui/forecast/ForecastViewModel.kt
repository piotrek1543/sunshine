package com.example.sunshine.ui.forecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunshine.domain.repository.WeatherRepository
import com.example.sunshine.domain.util.Resource
import com.example.sunshine.domain.weather.WeatherInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val repository: WeatherRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<ViewState>(ViewState.Loading)
    val state = _state.asStateFlow()

    init {
        getForecast()
    }

    private fun getForecast() {
        viewModelScope.launch {
            _state.emit(ViewState.Loading)
            @Suppress("MagicNumber", "ComplexMethod")
            when (val result = repository.getWeatherData(52.40692, 16.92993)) {
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
}
