package com.example.sunshine.data.db.mapper

import com.example.sunshine.data.db.model.CachedRain
import com.example.sunshine.domain.model.Rain
import javax.inject.Inject

/**
 * Map a [CachedRain] instance to and from a [Rain] instance when data is moving between
 * this later and the Data layer
 */
open class CachedRainMapper @Inject constructor() :
    CachedMapper<CachedRain, Rain> {

    /**
     * Map a [Rain] instance to a [CachedRain] instance
     */
    override fun mapToCached(type: Rain): CachedRain =
        CachedRain(_3h = type._3h, listDt = type.listDt)

    /**
     * Map a [CachedRain] instance to a [Rain] instance
     */
    override fun mapFromCached(type: CachedRain): Rain = Rain(_3h = type._3h, listDt = type.listDt)

}