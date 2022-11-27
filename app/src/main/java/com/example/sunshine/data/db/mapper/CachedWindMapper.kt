package com.example.sunshine.data.db.mapper

import com.example.sunshine.data.db.model.CachedWind
import com.example.sunshine.domain.model.Wind
import javax.inject.Inject

/**
 * Map a [CachedWind] instance to and from a [Wind] instance when data is moving between
 * this later and the Data layer
 */
open class CachedWindMapper @Inject constructor() :
    CachedMapper<CachedWind, Wind> {

    /**
     * Map a [Wind] instance to a [CachedWind] instance
     */
    override fun mapToCached(type: Wind): CachedWind = CachedWind(
        speed = type.speed,
        deg = type.deg,
        listDt = type.listDt
    )

    /**
     * Map a [CachedWind] instance to a [Wind] instance
     */
    override fun mapFromCached(type: CachedWind): Wind = Wind(
        speed = type.speed,
        deg = type.deg,
        listDt = type.listDt
    )
}
