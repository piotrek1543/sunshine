package com.example.sunshine.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Representation for a [ForecastView] instance for this layers Model representation
 */
@Parcelize
data class ForecastView(
    val date: Long,
    val dateTxt: String,
    val description: String,
    val tempMin: Double,
    val tempMax: Double,
    val icon: Int
) : Parcelable
