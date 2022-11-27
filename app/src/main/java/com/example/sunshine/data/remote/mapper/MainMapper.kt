package com.example.sunshine.data.remote.mapper

import com.example.sunshine.data.remote.model.MainModel
import com.example.sunshine.domain.model.Main
import javax.inject.Inject

/**
 * Map a [MainModel] to and from a [Main] instance when data is moving between
 * this later and the Data layer
 */
open class MainMapper @Inject constructor() : Mapper<MainModel, Main> {

    /**
     * Map an instance of a [MainModel] to a [Main] model
     */
    override fun mapFromRemote(type: MainModel): Main = Main(
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
