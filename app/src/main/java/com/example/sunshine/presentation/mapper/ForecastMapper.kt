package com.example.sunshine.presentation.mapper

import com.example.sunshine.domain.model.Forecast
import com.example.sunshine.domain.model.List
import com.example.sunshine.presentation.model.ForecastView
import javax.inject.Inject

private const val FORECAST_VIEW_DEFAULT_TEMP = 0.0
private const val FORECAST_VIEW_DEFAULT_DESC = ""
private const val FORECAST_VIEW_DEFAULT_ID = 500

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
            tempMin = type.main?.tempMin ?: FORECAST_VIEW_DEFAULT_TEMP,
            tempMax = type.main?.tempMax ?: FORECAST_VIEW_DEFAULT_TEMP,
            description = type.weather?.description ?: FORECAST_VIEW_DEFAULT_DESC,
            icon = type.weather?.id ?: FORECAST_VIEW_DEFAULT_ID
        )
}
