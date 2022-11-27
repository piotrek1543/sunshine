package com.example.sunshine.data.repository

import com.example.sunshine.data.remote.Constants
import com.example.sunshine.data.remote.ForecastService
import com.example.sunshine.data.remote.mapper.ForecastMapper
import com.example.sunshine.domain.model.Forecast
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ForecastRepository @Inject constructor(
    private val forecastService: ForecastService,
    private val forecastMapper: ForecastMapper,
) {

    suspend fun getForecast(): Forecast {
        val query = Constants.QUERY
        val mode = Constants.MODE
        val units = Constants.UNITS
        val type = Constants.TYPE
        val appId = Constants.APPID
        val lang = Locale.getDefault().language
        val forecastModel = forecastService.get(query, mode, units, type, lang, appId)
        return forecastMapper.mapFromRemote(forecastModel)
    }
}
