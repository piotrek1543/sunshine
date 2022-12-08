package com.example.sunshine.data.remote.mapper

import com.example.sunshine.data.remote.model.HourlyEntity
import com.example.sunshine.domain.weather.WeatherData
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class HourlyEntityMapper @Inject constructor() : EntityMapper<HourlyEntity, List<WeatherData>> {

    override fun mapFromRemote(type: HourlyEntity): List<WeatherData> = with(type) {
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
}
