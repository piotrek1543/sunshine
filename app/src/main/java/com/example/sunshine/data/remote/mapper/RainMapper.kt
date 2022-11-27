package com.example.sunshine.data.remote.mapper

import com.example.sunshine.data.remote.model.RainModel
import com.example.sunshine.domain.model.Rain
import javax.inject.Inject

/**
 * Map a [RainModel] to and from a [Rain] instance when data is moving between
 * this later and the Data layer
 */
open class RainMapper @Inject constructor() : Mapper<RainModel, Rain> {

    /**
     * Map an instance of a [RainModel] to a [Rain] model
     */
    override fun mapFromRemote(type: RainModel): Rain =
        Rain(in3h = type.in3h, listDt = type.listDt)
}
