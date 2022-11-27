package com.example.sunshine.ui.forecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunshine.data.repository.ForecastRepository
import com.example.sunshine.domain.model.Forecast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val forecastRepository: ForecastRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<ViewState>(ViewState.Loading)
    val state = _state.asStateFlow()

    init {
        getForecast()
    }

    private fun getForecast() {
        viewModelScope.launch {
            _state.emit(ViewState.Loading)
            try {
                val forecast = forecastRepository.getForecast()
                _state.emit(ViewState.Success(forecast))
            } catch (exception: Exception) {
                _state.emit(ViewState.Error(exception))
            }
        }
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class Success(
            val forecast: Forecast,
        ) : ViewState()

        data class Error(
            val exception: Exception,
        ) : ViewState()
    }
}