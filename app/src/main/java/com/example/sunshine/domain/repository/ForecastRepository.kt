package com.example.sunshine.domain.repository

import com.example.sunshine.domain.model.Forecast

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain layer.
 * This is to be implemented by the data layer, setting the requirements for the
 * operations that need to be implemented
 */
interface ForecastRepository {

    suspend fun clearForecast()

    suspend fun saveForecast(forecast: Forecast)

    suspend fun getForecast(): Forecast

}