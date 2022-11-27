package com.example.sunshine.data.db.mapper

import com.example.sunshine.data.db.model.CachedWeather
import com.example.sunshine.domain.model.Weather
import javax.inject.Inject

/**
 * Map a [CachedWeather] instance to and from a [Weather] instance when data is moving between
 * this later and the Data layer
 */
open class CachedWeatherMapper @Inject constructor() :
    CachedMapper<CachedWeather, Weather> {

    /**
     * Map a [Weather] instance to a [CachedWeather] instance
     */
    override fun mapToCached(type: Weather): CachedWeather =
        CachedWeather(
            id = type.id,
            main = type.main,
            description = type.description,
            icon = type.icon,
            listDt = type.listDt
        )

    /**
     * Map a [CachedWeather] instance to a [Weather] instance
     */
    override fun mapFromCached(type: CachedWeather): Weather =
        Weather(
            id = type.id,
            main = type.main,
            description = type.description,
            icon = type.icon,
            listDt = type.listDt
        )

}