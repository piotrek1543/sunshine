package com.example.sunshine.data.remote.mapper

import com.example.sunshine.data.remote.model.PodModel
import com.example.sunshine.domain.model.Pod
import javax.inject.Inject

/**
 * Map a [PodModel] to and from a [Pod] instance when data is moving between
 * this later and the Data layer
 */
open class PodMapper @Inject constructor() : Mapper<PodModel, Pod> {

    /**
     * Map an instance of a [PodModel] to a [Pod] model
     */
    override fun mapFromRemote(type: PodModel): Pod = Pod(pod = type.pod, listDt = type.listDt)
}
