package com.example.sunshine.data.db.mapper

import com.example.sunshine.data.db.model.CachedSnow
import com.example.sunshine.domain.model.Snow
import javax.inject.Inject

/**
 * Map a [CachedSnow] instance to and from a [Snow] instance when data is moving between
 * this later and the Data layer
 */
open class CachedSnowMapper @Inject constructor() :
    CachedMapper<CachedSnow, Snow> {

    /**
     * Map a [Snow] instance to a [CachedSnow] instance
     */
    override fun mapToCached(type: Snow): CachedSnow =
        CachedSnow(_3h = type._3h, listDt = type.listDt)

    /**
     * Map a [CachedSnow] instance to a [Snow] instance
     */
    override fun mapFromCached(type: CachedSnow): Snow = Snow(_3h = type._3h, listDt = type.listDt)

}