package com.example.sunshine.data.db.mapper

import com.example.sunshine.data.db.model.CachedMain
import com.example.sunshine.domain.model.Main
import javax.inject.Inject

/**
 * Map a [CachedMain] instance to and from a [Main] instance when data is moving between
 * this later and the Data layer
 */
open class CachedMainMapper @Inject constructor() :
    CachedMapper<CachedMain, Main> {

    /**
     * Map a [Main] instance to a [CachedMain] instance
     */
    override fun mapToCached(type: Main): CachedMain = CachedMain(
        temp = type.temp,
        tempMin = type.tempMin,
        tempMax = type.tempMax,
        pressure = type.pressure,
        seaLevel = type.seaLevel,
        grndLevel = type.grndLevel,
        humidity = type.humidity,
        tempKf = type.tempKf,
        listDt = type.listDt
    )

    /**
     * Map a [CachedMain] instance to a [Main] instance
     */
    override fun mapFromCached(type: CachedMain): Main = Main(
        temp = type.temp,
        tempMin = type.tempMin,
        tempMax = type.tempMax,
        pressure = type.pressure,
        seaLevel = type.seaLevel,
        grndLevel = type.grndLevel,
        humidity = type.humidity,
        tempKf = type.tempKf,
        listDt = type.listDt
    )

}
