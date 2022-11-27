package com.example.sunshine.data.remote.mapper

import com.example.sunshine.data.remote.model.CityModel
import com.example.sunshine.domain.model.City
import javax.inject.Inject

/**
 * Map a [CityModel] to and from a [City] instance when data is moving between
 * this later and the Data layer
 */
open class CityMapper @Inject constructor(private val coordMapper: CoordMapper) : Mapper<CityModel, City> {

    /**
     * Map an instance of a [CityModel] to a [City] model
     */
    override fun mapFromRemote(type: CityModel): City = City(
            id = type.id,
            name = type.name,
            country = type.country,
            population = type.population,
            coord = type.coord?.let { coordMapper.mapFromRemote(it) })
}