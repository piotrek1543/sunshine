package com.example.sunshine.data.remote.mapper

import com.example.sunshine.data.remote.model.Forecast
import com.example.sunshine.data.remote.model.Hourly
import com.example.sunshine.domain.weather.WeatherData
import com.example.sunshine.domain.weather.WeatherInfo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Suppress("MagicNumber")
fun Hourly.toWeatherDataList(): List<WeatherData> {
    return time?.mapIndexed { index, time ->
        val temperature = temperature2m?.get(index)
        val weatherCode = weathercode?.get(index)
        val windSpeed = windspeed10m?.get(index)
        val pressure = pressureMsl?.get(index)
        val humidity = relativehumidity2m?.get(index)
        WeatherData(
            id = index,
            time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
            temperatureCelsius = temperature,
            pressure = pressure,
            windSpeed = windSpeed,
            humidity = humidity,
            weatherCode = weatherCode
        )
    } ?: emptyList()
}

@Suppress("MagicNumber")
fun Forecast.toWeatherInfo(): WeatherInfo {
    val weatherDataList = hourly?.toWeatherDataList() ?: emptyList()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataList.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time?.hour == hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataList.groupBy { (index) -> index / 24 },
        currentWeatherData = currentWeatherData
    )
}
