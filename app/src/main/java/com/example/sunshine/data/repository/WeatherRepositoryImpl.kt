package com.example.sunshine.data.repository

import com.example.sunshine.data.mappers.toWeatherInfo
import com.example.sunshine.data.remote.WeatherApi
import com.example.sunshine.domain.repository.WeatherRepository
import com.example.sunshine.domain.util.Resource
import com.example.sunshine.domain.weather.WeatherInfo
import timber.log.Timber
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    @Suppress("TooGenericExceptionCaught")
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getForecast(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: RuntimeException) {
            Timber.e(e)
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}
