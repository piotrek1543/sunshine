package com.example.sunshine.ui.model

import com.example.sunshine.R

@Suppress("ComplexMethod", "ReturnCount")
object WeatherDecoder {

    fun getStringRes(code: Int): Int {
        when (code) {
            WeatherCodes.CLEAR_SKY -> return R.string.weather_type_clear_sky
            WeatherCodes.MAINLY_CLEAR -> return R.string.weather_type_mainly_clear
            WeatherCodes.PARTLY_CLOUDY -> return R.string.weather_type_partly_cloudy
            WeatherCodes.OVERCAST -> return R.string.weather_type_overcast
            WeatherCodes.FOGGY -> return R.string.weather_type_foggy
            WeatherCodes.DEPOSITING_RIME_FOG -> return R.string.weather_type_depositing_rime_fog
            WeatherCodes.LIGHT_DRIZZLE -> return R.string.weather_type_light_drizzle
            WeatherCodes.MODERATE_DRIZZLE -> return R.string.weather_type_moderate_drizzle
            WeatherCodes.DENSE_DRIZZLE -> return R.string.weather_type_dense_drizzle
            WeatherCodes.LIGHT_FREEZING_DRIZZLE -> return R.string.weather_type_slight_freezing_drizzle
            WeatherCodes.DENSE_FREEZING_DRIZZLE -> return R.string.weather_type_dense_freezing_drizzle
            WeatherCodes.SLIGHT_RAIN -> return R.string.weather_type_slight_rain
            WeatherCodes.MODERATE_RAIN -> return R.string.weather_type_rainy
            WeatherCodes.HEAVY_RAIN -> return R.string.weather_type_heavy_rain
            WeatherCodes.LIGHT_FREEZING_RAIN -> return R.string.weather_type_heavy_freezing_rain
            WeatherCodes.HEAVY_FREEZING_RAIN -> return R.string.weather_type_heavy_freezing_rain
            WeatherCodes.SLIGHT_SNOWFALL -> return R.string.weather_type_slight_snow_fall
            WeatherCodes.MODERATE_SNOWFALL -> return R.string.weather_type_moderate_snow_fall
            WeatherCodes.HEAVY_SNOWFALL -> return R.string.weather_type_heavy_snow_fall
            WeatherCodes.SNOW_GRAINS -> return R.string.weather_type_snow_grains
            WeatherCodes.SLIGHT_RAIN_SHOWERS -> return R.string.weather_type_slight_rain_showers
            WeatherCodes.MODERATE_RAIN_SHOWERS -> return R.string.weather_type_moderate_rain_showers
            WeatherCodes.VIOLENT_RAIN_SHOWERS -> return R.string.weather_type_violent_rain_showers
            WeatherCodes.SLIGHT_SNOW_SHOWERS -> return R.string.weather_type_light_snow_showers
            WeatherCodes.HEAVY_SNOW_SHOWERS -> return R.string.weather_type_heavy_snow_showers
            WeatherCodes.MODERATE_THUNDERSTORM -> return R.string.weather_type_moderate_thunderstorm
            WeatherCodes.SLIGHT_HAIL_THUNDERSTORM -> return R.string.weather_type_thunderstorm_with_slight_hail
            WeatherCodes.HEAVY_HAIL_THUNDERSTORM -> return R.string.weather_type_thunderstorm_with_heavy_hail
            else -> return R.string.weather_type_unknown
        }
    }

    fun getIconRes(code: Int, isNight: Boolean): Int =
        when (isNight) {
            true -> when (code) {
                WeatherCodes.CLEAR_SKY -> R.drawable.icon_clear_sky_night
                WeatherCodes.MAINLY_CLEAR -> R.drawable.icon_few_clouds_night
                WeatherCodes.PARTLY_CLOUDY -> R.drawable.icon_broken_clouds_night
                WeatherCodes.OVERCAST -> R.drawable.icon_scattered_clouds_night
                WeatherCodes.FOGGY -> R.drawable.icon_mist_night
                WeatherCodes.DEPOSITING_RIME_FOG -> R.drawable.icon_scattered_clouds_night
                WeatherCodes.LIGHT_DRIZZLE -> R.drawable.icon_shower_rain_night
                WeatherCodes.MODERATE_DRIZZLE -> R.drawable.icon_shower_rain_night
                WeatherCodes.DENSE_DRIZZLE -> R.drawable.icon_rain_night
                WeatherCodes.LIGHT_FREEZING_DRIZZLE -> R.drawable.icon_shower_rain_night
                WeatherCodes.DENSE_FREEZING_DRIZZLE -> R.drawable.icon_shower_rain_night
                WeatherCodes.SLIGHT_RAIN -> R.drawable.icon_rain_night
                WeatherCodes.MODERATE_RAIN -> R.drawable.icon_rain_night
                WeatherCodes.HEAVY_RAIN -> R.drawable.icon_rain_night
                WeatherCodes.LIGHT_FREEZING_RAIN -> R.drawable.icon_rain_night
                WeatherCodes.HEAVY_FREEZING_RAIN -> R.drawable.icon_rain_night
                WeatherCodes.SLIGHT_SNOWFALL -> R.drawable.icon_rain_night
                WeatherCodes.MODERATE_SNOWFALL -> R.drawable.icon_snow_night
                WeatherCodes.HEAVY_SNOWFALL -> R.drawable.icon_heavy_snow_night
                WeatherCodes.SNOW_GRAINS -> R.drawable.icon_heavy_snow_night
                WeatherCodes.SLIGHT_RAIN_SHOWERS -> R.drawable.icon_shower_rain_night
                WeatherCodes.MODERATE_RAIN_SHOWERS -> R.drawable.icon_shower_rain_night
                WeatherCodes.VIOLENT_RAIN_SHOWERS -> R.drawable.icon_shower_rain_night
                WeatherCodes.SLIGHT_SNOW_SHOWERS -> R.drawable.icon_snow_night
                WeatherCodes.HEAVY_SNOW_SHOWERS -> R.drawable.icon_heavy_snow_night
                WeatherCodes.MODERATE_THUNDERSTORM -> R.drawable.icon_thunderstorm_night
                WeatherCodes.SLIGHT_HAIL_THUNDERSTORM -> R.drawable.icon_thunderstorm_night
                WeatherCodes.HEAVY_HAIL_THUNDERSTORM -> R.drawable.icon_thunderstorm_night
                else -> R.drawable.icon_clear_sky_night // shouldn't happen anyways
            }

            false -> when (code) {
                WeatherCodes.CLEAR_SKY -> R.drawable.icon_clear_sky_day
                WeatherCodes.MAINLY_CLEAR -> R.drawable.icon_few_clouds_day
                WeatherCodes.PARTLY_CLOUDY -> R.drawable.icon_broken_clouds_day
                WeatherCodes.OVERCAST -> R.drawable.icon_scattered_clouds_day
                WeatherCodes.FOGGY -> R.drawable.icon_mist_day
                WeatherCodes.DEPOSITING_RIME_FOG -> R.drawable.icon_scattered_clouds_day
                WeatherCodes.LIGHT_DRIZZLE -> R.drawable.icon_shower_rain_day
                WeatherCodes.MODERATE_DRIZZLE -> R.drawable.icon_shower_rain_day
                WeatherCodes.DENSE_DRIZZLE -> R.drawable.icon_rain_day
                WeatherCodes.LIGHT_FREEZING_DRIZZLE -> R.drawable.icon_shower_rain_day
                WeatherCodes.DENSE_FREEZING_DRIZZLE -> R.drawable.icon_shower_rain_day
                WeatherCodes.SLIGHT_RAIN -> R.drawable.icon_rain_day
                WeatherCodes.MODERATE_RAIN -> R.drawable.icon_rain_day
                WeatherCodes.HEAVY_RAIN -> R.drawable.icon_rain_day
                WeatherCodes.LIGHT_FREEZING_RAIN -> R.drawable.icon_rain_day
                WeatherCodes.HEAVY_FREEZING_RAIN -> R.drawable.icon_rain_day
                WeatherCodes.SLIGHT_SNOWFALL -> R.drawable.icon_rain_day
                WeatherCodes.MODERATE_SNOWFALL -> R.drawable.icon_snow_day
                WeatherCodes.HEAVY_SNOWFALL -> R.drawable.icon_heavy_snow_day
                WeatherCodes.SNOW_GRAINS -> R.drawable.icon_heavy_snow_day
                WeatherCodes.SLIGHT_RAIN_SHOWERS -> R.drawable.icon_shower_rain_day
                WeatherCodes.MODERATE_RAIN_SHOWERS -> R.drawable.icon_shower_rain_day
                WeatherCodes.VIOLENT_RAIN_SHOWERS -> R.drawable.icon_shower_rain_day
                WeatherCodes.SLIGHT_SNOW_SHOWERS -> R.drawable.icon_snow_day
                WeatherCodes.HEAVY_SNOW_SHOWERS -> R.drawable.icon_heavy_snow_day
                WeatherCodes.MODERATE_THUNDERSTORM -> R.string.weather_type_moderate_thunderstorm
                WeatherCodes.SLIGHT_HAIL_THUNDERSTORM -> R.string.weather_type_thunderstorm_with_slight_hail
                WeatherCodes.HEAVY_HAIL_THUNDERSTORM -> R.drawable.icon_thunderstorm_day
                else -> R.drawable.icon_clear_sky_day
            }
        }

    fun getBackgroundsRes(code: Int, isNight: Boolean): Int =
        when (isNight) {
            true -> when (code) {
                WeatherCodes.CLEAR_SKY -> R.drawable.illustration_clear_sky_night
                WeatherCodes.MAINLY_CLEAR -> R.drawable.illustration_few_clouds_night
                WeatherCodes.PARTLY_CLOUDY -> R.drawable.illustration_broken_clouds_night
                WeatherCodes.OVERCAST -> R.drawable.illustration_scattered_clouds_night
                WeatherCodes.FOGGY -> R.drawable.illustration_mist_night
                WeatherCodes.DEPOSITING_RIME_FOG -> R.drawable.illustration_scattered_clouds_night
                WeatherCodes.LIGHT_DRIZZLE -> R.drawable.illustration_shower_rain_night
                WeatherCodes.MODERATE_DRIZZLE -> R.drawable.illustration_shower_rain_night
                WeatherCodes.DENSE_DRIZZLE -> R.drawable.illustration_rain_night
                WeatherCodes.LIGHT_FREEZING_DRIZZLE -> R.drawable.illustration_shower_rain_night
                WeatherCodes.DENSE_FREEZING_DRIZZLE -> R.drawable.illustration_shower_rain_night
                WeatherCodes.SLIGHT_RAIN -> R.drawable.illustration_rain_night
                WeatherCodes.MODERATE_RAIN -> R.drawable.illustration_rain_night
                WeatherCodes.HEAVY_RAIN -> R.drawable.illustration_rain_night
                WeatherCodes.LIGHT_FREEZING_RAIN -> R.drawable.illustration_rain_night
                WeatherCodes.HEAVY_FREEZING_RAIN -> R.drawable.illustration_rain_night
                WeatherCodes.SLIGHT_SNOWFALL -> R.drawable.illustration_rain_night
                WeatherCodes.MODERATE_SNOWFALL -> R.drawable.illustration_snow_night
                WeatherCodes.HEAVY_SNOWFALL -> R.drawable.illustration_heavy_snow_night
                WeatherCodes.SNOW_GRAINS -> R.drawable.illustration_heavy_snow_night
                WeatherCodes.SLIGHT_RAIN_SHOWERS -> R.drawable.illustration_shower_rain_night
                WeatherCodes.MODERATE_RAIN_SHOWERS -> R.drawable.illustration_shower_rain_night
                WeatherCodes.VIOLENT_RAIN_SHOWERS -> R.drawable.illustration_shower_rain_night
                WeatherCodes.SLIGHT_SNOW_SHOWERS -> R.drawable.illustration_snow_night
                WeatherCodes.HEAVY_SNOW_SHOWERS -> R.drawable.illustration_heavy_snow_night
                WeatherCodes.MODERATE_THUNDERSTORM -> R.drawable.illustration_thunderstorm_night
                WeatherCodes.SLIGHT_HAIL_THUNDERSTORM -> R.drawable.illustration_thunderstorm_night
                WeatherCodes.HEAVY_HAIL_THUNDERSTORM -> R.drawable.illustration_thunderstorm_night
                else -> R.drawable.illustration_thunderstorm_night
            }

            false -> when (code) {
                WeatherCodes.CLEAR_SKY -> R.drawable.illustration_clear_sky_day
                WeatherCodes.MAINLY_CLEAR -> R.drawable.illustration_few_clouds_day
                WeatherCodes.PARTLY_CLOUDY -> R.drawable.illustration_broken_clouds_day
                WeatherCodes.OVERCAST -> R.drawable.illustration_scattered_clouds_day
                WeatherCodes.FOGGY -> R.drawable.illustration_mist_day
                WeatherCodes.DEPOSITING_RIME_FOG -> R.drawable.illustration_scattered_clouds_day
                WeatherCodes.LIGHT_DRIZZLE -> R.drawable.illustration_shower_rain_day
                WeatherCodes.MODERATE_DRIZZLE -> R.drawable.illustration_shower_rain_day
                WeatherCodes.DENSE_DRIZZLE -> R.drawable.illustration_rain_day
                WeatherCodes.LIGHT_FREEZING_DRIZZLE -> R.drawable.illustration_shower_rain_day
                WeatherCodes.DENSE_FREEZING_DRIZZLE -> R.drawable.illustration_shower_rain_day
                WeatherCodes.SLIGHT_RAIN -> R.drawable.illustration_rain_day
                WeatherCodes.MODERATE_RAIN -> R.drawable.illustration_rain_day
                WeatherCodes.HEAVY_RAIN -> R.drawable.illustration_rain_day
                WeatherCodes.LIGHT_FREEZING_RAIN -> R.drawable.illustration_rain_day
                WeatherCodes.HEAVY_FREEZING_RAIN -> R.drawable.illustration_rain_day
                WeatherCodes.SLIGHT_SNOWFALL -> R.drawable.illustration_rain_day
                WeatherCodes.MODERATE_SNOWFALL -> R.drawable.illustration_snow_day
                WeatherCodes.HEAVY_SNOWFALL -> R.drawable.illustration_heavy_snow_day
                WeatherCodes.SNOW_GRAINS -> R.drawable.illustration_heavy_snow_day
                WeatherCodes.SLIGHT_RAIN_SHOWERS -> R.drawable.illustration_shower_rain_day
                WeatherCodes.MODERATE_RAIN_SHOWERS -> R.drawable.illustration_shower_rain_day
                WeatherCodes.VIOLENT_RAIN_SHOWERS -> R.drawable.illustration_shower_rain_day
                WeatherCodes.SLIGHT_SNOW_SHOWERS -> R.drawable.illustration_snow_day
                WeatherCodes.HEAVY_SNOW_SHOWERS -> R.drawable.illustration_heavy_snow_day
                WeatherCodes.MODERATE_THUNDERSTORM -> R.drawable.illustration_thunderstorm_day
                WeatherCodes.SLIGHT_HAIL_THUNDERSTORM -> R.drawable.illustration_thunderstorm_day
                WeatherCodes.HEAVY_HAIL_THUNDERSTORM -> R.drawable.illustration_thunderstorm_day
                else -> R.drawable.illustration_thunderstorm_day
            }
        }
}
