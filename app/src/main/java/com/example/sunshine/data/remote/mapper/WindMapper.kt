package com.example.sunshine.data.remote.mapper

import com.example.sunshine.data.remote.model.WindModel
import com.example.sunshine.domain.model.Wind
import javax.inject.Inject

/**
 * Map a [WindModel] to and from a [Wind] instance when data is moving between
 * this later and the Data layer
 */
open class WindMapper @Inject constructor() : Mapper<WindModel, Wind> {

    /**
     * Map an instance of a [WindModel] to a [Wind] model
     */
    override fun mapFromRemote(type: WindModel): Wind = Wind(
        speed = type.speed,
        deg = type.deg,
        listDt = type.listDt
    )
}
