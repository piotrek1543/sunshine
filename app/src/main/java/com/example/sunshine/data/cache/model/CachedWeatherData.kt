package com.example.sunshine.data.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "weather_data")
data class CachedWeatherData(
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,
    val time: LocalDateTime?,
    val temperatureCelsius: Double?,
    val pressure: Double?,
    val windSpeed: Double?,
    val humidity: Int?,
    val weatherCode: Int?
)
