package com.example.sunshine.domain.weather

import java.time.LocalDateTime

data class WeatherData(
    val id: Int,
    val time: LocalDateTime?,
    val temperatureCelsius: Double?,
    val pressure: Double?,
    val windSpeed: Double?,
    val humidity: Int?,
    val weatherCode: Int?
)
