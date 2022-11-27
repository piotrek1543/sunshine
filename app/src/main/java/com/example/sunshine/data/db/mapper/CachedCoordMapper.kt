package com.example.sunshine.data.db.mapper

import com.example.sunshine.data.db.model.CachedCoord
import com.example.sunshine.domain.model.Coord
import javax.inject.Inject

/**
 * Map a [CachedCoord] instance to and from a [Coord] instance when data is moving between
 * this later and the Data layer
 */
open class CachedCoordMapper @Inject constructor() :
    CachedMapper<CachedCoord, Coord> {

    /**
     * Map a [Coord] instance to a [CachedCoord] instance
     */
    override fun mapToCached(type: Coord) = CachedCoord(
            cityId = type.cityId,
            lat = type.lat,
            lon = type.lon
    )

    /**
     * Map a [CachedCoord] instance to a [Coord] instance
     */
    override fun mapFromCached(type: CachedCoord): Coord = Coord(
            cityId = type.cityId,
            lat = type.lat,
            lon = type.lon
    )

}
