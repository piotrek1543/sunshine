package com.example.sunshine.domain.model


/**
 * Representation for a [Coord] fetched from an external layer data source
 */
data class Coord(
    val cityId: Int? = null,
    val lon: Double? = null,
    val lat: Double? = null
)
