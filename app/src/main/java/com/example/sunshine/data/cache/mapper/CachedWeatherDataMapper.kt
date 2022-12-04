package com.example.sunshine.data.cache.mapper

import com.example.sunshine.data.cache.model.CachedWeatherData
import com.example.sunshine.domain.weather.WeatherData
import javax.inject.Inject

class CachedWeatherDataMapper @Inject constructor() : CachedMapper<CachedWeatherData, WeatherData> {

    override fun mapFromCached(type: CachedWeatherData) = WeatherData(
        id = type.id,
        time = type.time,
        temperatureCelsius = type.temperatureCelsius,
        pressure = type.pressure,
        windSpeed = type.windSpeed,
        humidity = type.humidity,
        weatherCode = type.weatherCode,
    )

    override fun mapToCached(type: WeatherData) = CachedWeatherData(
        id = type.id,
        time = type.time,
        temperatureCelsius = type.temperatureCelsius,
        pressure = type.pressure,
        windSpeed = type.windSpeed,
        humidity = type.humidity,
        weatherCode = type.weatherCode,
    )
}
