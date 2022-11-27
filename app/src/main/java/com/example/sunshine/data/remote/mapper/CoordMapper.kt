package com.example.sunshine.data.remote.mapper

import com.example.sunshine.data.remote.model.CoordModel
import com.example.sunshine.domain.model.Coord
import javax.inject.Inject

/**
 * Map a [CoordModel] to and from a [Coord] instance when data is moving between
 * this later and the Data layer
 */
open class CoordMapper @Inject constructor() : Mapper<CoordModel, Coord> {

    /**
     * Map an instance of a [CoordModel] to a [Coord] model
     */
    override fun mapFromRemote(type: CoordModel): Coord = Coord(lat = type.lat, lon = type.lon)

}