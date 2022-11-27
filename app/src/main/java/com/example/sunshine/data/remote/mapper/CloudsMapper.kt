package com.example.sunshine.data.remote.mapper

import com.example.sunshine.data.remote.model.CloudsModel
import com.example.sunshine.domain.model.Clouds
import javax.inject.Inject

/**
 * Map a [CloudsModel] to and from a [Clouds] instance when data is moving between
 * this later and the Data layer
 */
open class CloudsMapper @Inject constructor() : Mapper<CloudsModel, Clouds> {

    /**
     * Map an instance of a [CloudsModel] to a [Clouds] model
     */
    override fun mapFromRemote(type: CloudsModel): Clouds = Clouds(
        all = type.all,
        listDt = type.listDt
    )

}