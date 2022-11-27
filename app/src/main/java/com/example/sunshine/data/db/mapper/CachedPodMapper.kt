package com.example.sunshine.data.mapper

import com.example.sunshine.data.db.mapper.CachedMapper
import com.example.sunshine.data.db.model.CachedPod
import com.example.sunshine.domain.model.Pod
import javax.inject.Inject

/**
 * Map a [CachedPod] instance to and from a [Pod] instance when data is moving between
 * this later and the Data layer
 */
open class CachedPodMapper @Inject constructor() :
    CachedMapper<CachedPod, Pod> {

    /**
     * Map a [Pod] instance to a [CachedPod] instance
     */
    override fun mapToCached(type: Pod): CachedPod = CachedPod(pod = type.pod, listDt = type.listDt)

    /**
     * Map a [CachedPod] instance to a [Pod] instance
     */
    override fun mapFromCached(type: CachedPod): Pod = Pod(pod = type.pod, listDt = type.listDt)

}
