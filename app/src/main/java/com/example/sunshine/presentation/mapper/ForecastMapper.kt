package com.example.sunshine.presentation.mapper

import com.example.sunshine.domain.model.Forecast
import com.example.sunshine.domain.model.List
import com.example.sunshine.ui.forecast.ForecastView
import com.example.sunshine.ui.utils.SunshineWeatherUtils
import javax.inject.Inject

/**
 * Map a [ForecastView] to and from a [List] instance when data is moving between
 * this layer and the Domain layer
 */
open class ForecastMapper @Inject constructor() : Mapper<ForecastView, List> {

    /**
     * Map a [Forecast] instance to a [ForecastView] instance
     */
    override fun mapToView(type: List): ForecastView =
        ForecastView(
            dateTxt = type.dtTxt ?: "",
            date = type.dt ?: 0,
            tempMin = type.main?.tempMin ?: 0.0,
            tempMax = type.main?.tempMax ?: 0.0,
            description = type.weather?.description ?: "",
            icon = type.weather?.id ?: 500
        )

}