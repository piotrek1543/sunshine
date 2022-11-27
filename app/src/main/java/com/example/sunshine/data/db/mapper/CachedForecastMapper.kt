package com.example.sunshine.data.db.mapper

import com.example.sunshine.data.db.model.CachedForecast
import com.example.sunshine.domain.model.Forecast
import javax.inject.Inject

/**
 * Map a [CachedForecast] instance to and from a [Forecast] instance when data is moving between
 * this later and the Data layer
 */
open class CachedForecastMapper @Inject constructor() :
    CachedMapper<CachedForecast, Forecast> {

    /**
     * Map a [Forecast] instance to a [CachedForecast] instance
     */
    override fun mapToCached(type: Forecast): CachedForecast {
        return CachedForecast(cod = type.cod, cnt = type.cnt, message = type.message)
    }

    /**
     * Map a [CachedForecast] instance to a [Forecast] instance
     */
    override fun mapFromCached(type: CachedForecast): Forecast {
        return Forecast(cod = type.cod, cnt = type.cnt, message = type.message)
    }
}
