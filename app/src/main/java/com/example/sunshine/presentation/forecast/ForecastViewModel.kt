package com.example.sunshine.presentation.forecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sunshine.data.repository.ForecastRepository
import com.example.sunshine.presentation.mapper.ForecastMapper
import com.example.sunshine.ui.forecast.ForecastView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val forecastRepository: ForecastRepository,
    private val forecastMapper: ForecastMapper,
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
                val list = forecast.list
                    ?.map {
                        forecastMapper.mapToView(it)
                    }?: emptyList()
                _state.emit(ViewState.Success(list))
            } catch (exception: Exception) {
                _state.emit(ViewState.Error(exception))
            }
        }
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class Success(
            val data: List<ForecastView>,
        ) : ViewState()

        data class Error(
            val exception: Exception,
        ) : ViewState()
    }
}