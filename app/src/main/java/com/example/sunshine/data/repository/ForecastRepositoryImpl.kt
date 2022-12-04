package com.example.sunshine.data.repository

import com.example.sunshine.data.cache.dao.CachedWeatherDataDao
import com.example.sunshine.data.cache.mapper.CachedWeatherDataMapper
import com.example.sunshine.data.remote.mapper.HourlyEntityMapper
import com.example.sunshine.data.remote.service.ForecastService
import com.example.sunshine.domain.repository.ForecastRepository
import com.example.sunshine.domain.util.Resource
import com.example.sunshine.domain.weather.WeatherData
import timber.log.Timber
import java.net.UnknownHostException
import javax.inject.Inject

class ForecastRepositoryImpl @Inject constructor(
    private val api: ForecastService,
    private val entityMapper: HourlyEntityMapper,
    private val weatherDataDao: CachedWeatherDataDao,
    private val weatherDataMapper: CachedWeatherDataMapper,
) : ForecastRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<List<WeatherData>> {
        return try {
            val hourly = api.getForecast(lat = lat, long = long).hourly
            val weatherData = hourly?.let { entityMapper.mapFromRemote(hourly) }
            weatherData?.let { data ->
                weatherDataDao.insertAll(
                    data.map { weatherDataMapper.mapToCached(it) }
                )
            }
            Resource.Success(
                data = weatherData
            )
        } catch (e: UnknownHostException) {
            Timber.e(e)
            Resource.Error(
                data = weatherDataDao.getAll().map { weatherDataMapper.mapFromCached(it) },
                message = e.message ?: "An unknown error occurred."
            )
        }
    }
}
