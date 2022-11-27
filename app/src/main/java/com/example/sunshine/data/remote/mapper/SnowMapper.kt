package com.example.sunshine.data.remote.mapper

import com.example.sunshine.data.remote.model.SnowModel
import com.example.sunshine.domain.model.Snow
import javax.inject.Inject

/**
 * Map a [SnowModel] to and from a [Snow] instance when data is moving between
 * this later and the Data layer
 */
open class SnowMapper @Inject constructor() : Mapper<SnowModel, Snow> {

    /**
     * Map an instance of a [SnowModel] to a [Snow] model
     */
    override fun mapFromRemote(type: SnowModel): Snow = Snow(in3h = type.in3h, listDt = type.listDt)
}
