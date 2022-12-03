package com.example.sunshine.data.mappers

import com.example.sunshine.data.remote.Forecast
import com.example.sunshine.data.remote.Hourly
import com.example.sunshine.domain.weather.WeatherData
import com.example.sunshine.domain.weather.WeatherInfo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

@Suppress("MagicNumber")
fun Hourly.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time?.mapIndexed { index, time ->
        val temperature = temperature2m?.get(index)
        val weatherCode = weathercode?.get(index)
        val windSpeed = windspeed10m?.get(index)
        val pressure = pressureMsl?.get(index)
        val humidity = relativehumidity2m?.get(index)
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherCode = weatherCode
            )
        )
    }?.groupBy {
        it.index / 24
    }?.mapValues {
        it.value.map { it.data }
    } ?: emptyMap()
}

@Suppress("MagicNumber")
fun Forecast.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = hourly?.toWeatherDataMap() ?: emptyMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time?.hour == hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}
