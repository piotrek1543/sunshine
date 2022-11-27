package com.example.sunshine.domain.model

/**
 * Representation for a [Wind] fetched from an external layer data source
 */
data class Wind(
        val speed: Double? = null,
        val deg: Float? = null,
        val listDt: Long?
)