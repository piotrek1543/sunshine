package com.example.sunshine.domain.model

/**
 * Representation for a [Rain] fetched from an external layer data source
 */
data class Rain(
    var in3h: Double? = null,
    val listDt: Long?,
)
