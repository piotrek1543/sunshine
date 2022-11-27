package com.example.sunshine.data.remote.mapper

import com.example.sunshine.data.remote.model.ForecastModel
import com.example.sunshine.domain.model.Forecast
import javax.inject.Inject

/**
 * Map a [ForecastModel] to and from a [Forecast] instance when data is moving between
 * this later and the Data layer
 */
open class ForecastMapper @Inject constructor(
    private val cityMapper: CityMapper,
    private val listMapper: ListMapper
) : Mapper<ForecastModel, Forecast> {

    /**
     * Map an instance of a [ForecastModel] to a [Forecast] model
     */
    override fun mapFromRemote(type: ForecastModel): Forecast = Forecast(
        cod = type.cod,
        cnt = type.cnt,
        message = type.message,
        city = type.city?.let { cityMapper.mapFromRemote(it) },
        list = type.list?.map { listModel -> let { listMapper.mapFromRemote(listModel) } }
    )
}
