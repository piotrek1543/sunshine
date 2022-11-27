package com.example.sunshine.data.db.mapper

import com.example.sunshine.data.db.model.CachedList
import com.example.sunshine.domain.model.List
import javax.inject.Inject

/**
 * Map a [CachedList] instance to and from a [List] instance when data is moving between
 * this later and the Data layer
 */
open class CachedListMapper @Inject constructor() :
    CachedMapper<CachedList, List> {

    /**
     * Map a [List] instance to a [CachedList] instance
     */
    override fun mapToCached(type: List): CachedList = CachedList(
        dt = type.dt,
        dtTxt = type.dtTxt
    )

    /**
     * Map a [CachedList] instance to a [List] instance
     */
    override fun mapFromCached(type: CachedList): List = List(
        dt = type.dt,
        dtTxt = type.dtTxt
    )

}