package com.example.sunshine.data.db.mapper

import com.example.sunshine.data.db.model.CachedClouds
import com.example.sunshine.domain.model.Clouds
import javax.inject.Inject

/**
 * Map a [CachedClouds] instance to and from a [Clouds] instance when data is moving between
 * this later and the Data layer
 */
open class CachedCloudsMapper @Inject constructor() :
    CachedMapper<CachedClouds, Clouds> {

    /**
     * Map a [Clouds] instance to a [CachedClouds] instance
     */
    override fun mapToCached(type: Clouds): CachedClouds =
        CachedClouds(all = type.all, listDt = type.listDt)

    /**
     * Map a [CachedClouds] instance to a [Clouds] instance
     */
    override fun mapFromCached(type: CachedClouds): Clouds =
        Clouds(all = type.all, listDt = type.listDt)

}