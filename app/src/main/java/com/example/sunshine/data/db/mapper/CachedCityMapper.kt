package com.example.sunshine.data.db.mapper

import com.example.sunshine.data.db.model.CachedCity
import com.example.sunshine.domain.model.City
import java.util.*
import javax.inject.Inject

/**
 * Map a [CachedCity] instance to and from a [City] instance when data is moving between
 * this later and the Data layer
 */
open class CachedCityMapper @Inject constructor() :
    CachedMapper<CachedCity, City> {

    /**
     * Map a [City] instance to a [CachedCity] instance
     */
    override fun mapToCached(type: City): CachedCity {
        return CachedCity(
                id = type.id ?: Random().nextInt(100_000),
                name = type.name,
                country = type.country,
                population = type.population
        )
    }

    /**
     * Map a [CachedCity] instance to a [City] instance
     */
    override fun mapFromCached(type: CachedCity): City {
        return City(
                id = type.id,
                name = type.name,
                country = type.country,
                population = type.population
        )
    }

}