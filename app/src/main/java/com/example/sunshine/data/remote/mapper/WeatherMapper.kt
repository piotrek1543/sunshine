package com.example.sunshine.data.remote.mapper

import com.example.sunshine.data.remote.model.WeatherModel
import com.example.sunshine.domain.model.Weather
import javax.inject.Inject

/**
 * Map a [WeatherModel] to and from a [Weather] instance when data is moving between
 * this later and the Data layer
 */
open class WeatherMapper @Inject constructor() : Mapper<WeatherModel, Weather> {

    /**
     * Map an instance of a [WeatherModel] to a [Weather] model
     */
    override fun mapFromRemote(type: WeatherModel): Weather = Weather(
        id = type.id,
        main = type.main,
        description = type.description,
        icon = type.icon,
        listDt = type.listDt
    )
}
