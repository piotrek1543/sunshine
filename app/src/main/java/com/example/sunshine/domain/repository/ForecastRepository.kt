package com.example.sunshine.domain.repository

import com.example.sunshine.domain.util.Resource
import com.example.sunshine.domain.weather.WeatherData

interface ForecastRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<List<WeatherData>>
}
