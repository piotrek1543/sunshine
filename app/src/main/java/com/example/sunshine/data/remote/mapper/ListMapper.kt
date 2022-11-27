package com.example.sunshine.data.remote.mapper

import com.example.sunshine.data.remote.model.ListModel
import com.example.sunshine.domain.model.List
import javax.inject.Inject

/**
 * Map a [ListModel] to and from a [List] instance when data is moving between
 * this later and the Data layer
 */
open class ListMapper @Inject constructor(
    private val mainMapper: MainMapper,
    private val weatherMapper: WeatherMapper,
    private val cloudsMapper: CloudsMapper,
    private val windMapper: WindMapper,
    private val rainMapper: RainMapper,
    private val snowMapper: SnowMapper,
    private val podMapper: PodMapper
) : Mapper<ListModel, List> {

    /**
     * Map an instance of a [ListModel] to a [List] model
     */
    @Suppress("ComplexMethod")
    override fun mapFromRemote(type: ListModel): List {
        val mainModel = type.mainModel.apply { this?.listDt = type.dt }
        val weatherModel = type.weatherModel?.get(0)?.let { it.apply { this.listDt = type.dt } }
        val cloudsModel = type.cloudsModel.apply { this?.listDt = type.dt }
        val windModel = type.windModel.apply { this?.listDt = type.dt }
        val rainModel = type.rainModel.apply { this?.listDt = type.dt }
        val snowModel = type.snowModel.apply { this?.listDt = type.dt }
        val podModel = type.podModel.apply { this?.listDt = type.dt }
        return List(
            dt = type.dt,
            main = mainModel?.let { mainMapper.mapFromRemote(it) },
            weather = weatherModel?.let { weatherMapper.mapFromRemote(it) },
            clouds = cloudsModel?.let { cloudsMapper.mapFromRemote(it) },
            wind = windModel?.let { windMapper.mapFromRemote(it) },
            rain = rainModel?.let { rainMapper.mapFromRemote(it) },
            snow = snowModel?.let { snowMapper.mapFromRemote(it) },
            pod = podModel?.let { podMapper.mapFromRemote(it) },
            dtTxt = type.dtTxt
        )
    }

}
