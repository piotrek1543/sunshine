package com.example.sunshine.data.repository

import com.example.sunshine.data.remote.mapper.toWeatherInfo
import com.example.sunshine.data.remote.service.ForecastService
import com.example.sunshine.domain.repository.ForecastRepository
import com.example.sunshine.domain.util.Resource
import com.example.sunshine.domain.weather.WeatherInfo
import timber.log.Timber
import java.net.UnknownHostException
import javax.inject.Inject

class ForecastRepositoryImpl @Inject constructor(
    private val api: ForecastService
) : ForecastRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getForecast(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: UnknownHostException) {
            Timber.e(e)
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}
