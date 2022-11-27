package com.example.sunshine.domain.model


/**
 * Representation for a [Weather] fetched from an external layer data source
 */
data class Weather(
        val id: Int? = null,
        val main: String? = null,
        val description: String? = null,
        val icon: String? = null,
        val listDt: Long?,
)
