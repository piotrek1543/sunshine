package com.example.sunshine.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.sunshine.R

sealed class WeatherType(
    @StringRes val descriptionRes: Int,
    @DrawableRes val iconRes: Int
) {
    object ClearSky : WeatherType(
        descriptionRes = R.string.weather_type_clear_sky,
        iconRes = R.drawable.icon_clear_sky_day
    )

    object MainlyClear : WeatherType(
        descriptionRes = R.string.weather_type_mainly_clear,
        iconRes = R.drawable.icon_few_clouds_day
    )

    object PartlyCloudy : WeatherType(
        descriptionRes = R.string.weather_type_partly_cloudy,
        iconRes = R.drawable.icon_broken_clouds_day
    )

    object Overcast : WeatherType(
        descriptionRes = R.string.weather_type_overcast,
        iconRes = R.drawable.icon_scattered_clouds_day
    )

    object Foggy : WeatherType(
        descriptionRes = R.string.weather_type_foggy,
        iconRes = R.drawable.icon_mist_day
    )

    object DepositingRimeFog : WeatherType(
        descriptionRes = R.string.weather_type_depositing_rime_fog,
        iconRes = R.drawable.icon_scattered_clouds_day
    )

    object LightDrizzle : WeatherType(
        descriptionRes = R.string.weather_type_light_drizzle,
        iconRes = R.drawable.icon_shower_rain_day
    )

    object ModerateDrizzle : WeatherType(
        descriptionRes = R.string.weather_type_moderate_drizzle,
        iconRes = R.drawable.icon_shower_rain_day
    )

    object DenseDrizzle : WeatherType(
        descriptionRes = R.string.weather_type_dense_drizzle,
        iconRes = R.drawable.icon_rain_day
    )

    object LightFreezingDrizzle : WeatherType(
        descriptionRes = R.string.weather_type_slight_freezing_drizzle,
        iconRes = R.drawable.icon_shower_rain_day
    )

    object DenseFreezingDrizzle : WeatherType(
        descriptionRes = R.string.weather_type_dense_freezing_drizzle,
        iconRes = R.drawable.icon_shower_rain_day
    )

    object SlightRain : WeatherType(
        descriptionRes = R.string.weather_type_slight_rain,
        iconRes = R.drawable.icon_rain_day
    )

    object ModerateRain : WeatherType(
        descriptionRes = R.string.weather_type_rainy,
        iconRes = R.drawable.icon_rain_day
    )

    object HeavyRain : WeatherType(
        descriptionRes = R.string.weather_type_heavy_rain,
        iconRes = R.drawable.icon_rain_day
    )

    object HeavyFreezingRain : WeatherType(
        descriptionRes = R.string.weather_type_heavy_freezing_rain,
        iconRes = R.drawable.icon_rain_day
    )

    object SlightSnowFall : WeatherType(
        descriptionRes = R.string.weather_type_slight_snow_fall,
        iconRes = R.drawable.icon_snow_day
    )

    object ModerateSnowFall : WeatherType(
        descriptionRes = R.string.weather_type_moderate_snow_fall,
        iconRes = R.drawable.icon_heavy_snow_day
    )

    object HeavySnowFall : WeatherType(
        descriptionRes = R.string.weather_type_heavy_snow_fall,
        iconRes = R.drawable.icon_heavy_snow_day
    )

    object SnowGrains : WeatherType(
        descriptionRes = R.string.weather_type_snow_grains,
        iconRes = R.drawable.icon_snow_day
    )

    object SlightRainShowers : WeatherType(
        descriptionRes = R.string.weather_type_slight_rain_showers,
        iconRes = R.drawable.icon_snow_day
    )

    object ModerateRainShowers : WeatherType(
        descriptionRes = R.string.weather_type_moderate_rain_showers,
        iconRes = R.drawable.icon_snow_day
    )

    object ViolentRainShowers : WeatherType(
        descriptionRes = R.string.weather_type_heavy_snow_showers,
        iconRes = R.drawable.icon_snow_day
    )

    object SlightSnowShowers : WeatherType(
        descriptionRes = R.string.weather_type_light_snow_showers,
        iconRes = R.drawable.icon_snow_day
    )

    object HeavySnowShowers : WeatherType(
        descriptionRes = R.string.weather_type_heavy_snow_showers,
        iconRes = R.drawable.icon_snow_day
    )

    object ModerateThunderstorm : WeatherType(
        descriptionRes = R.string.weather_type_moderate_thunderstorm,
        iconRes = R.drawable.icon_thunderstorm_day
    )

    object SlightHailThunderstorm : WeatherType(
        descriptionRes = R.string.weather_type_thunderstorm_with_slight_hail,
        iconRes = R.drawable.icon_thunderstorm_day
    )

    object HeavyHailThunderstorm : WeatherType(
        descriptionRes = R.string.weather_type_thunderstorm_with_heavy_hail,
        iconRes = R.drawable.icon_thunderstorm_day
    )

    object Unknown : WeatherType(
        descriptionRes = R.string.weather_type_unknown,
        iconRes = R.drawable.icon_thunderstorm_day
    )

    companion object {
        @Suppress("ComplexMethod")
        fun of(code: Int?): WeatherType {
            return when (code) {
                WeatherCodes.CLEAR_SKY -> ClearSky
                WeatherCodes.MAINLY_CLEAR -> MainlyClear
                WeatherCodes.PARTLY_CLOUDY -> PartlyCloudy
                WeatherCodes.OVERCAST -> Overcast
                WeatherCodes.FOGGY -> Foggy
                WeatherCodes.DEPOSITING_RIME_FOG -> DepositingRimeFog
                WeatherCodes.LIGHT_DRIZZLE -> LightDrizzle
                WeatherCodes.MODERATE_DRIZZLE -> ModerateDrizzle
                WeatherCodes.DENSE_DRIZZLE -> DenseDrizzle
                WeatherCodes.LIGHT_FREEZING_DRIZZLE -> LightFreezingDrizzle
                WeatherCodes.DENSE_FREEZING_DRIZZLE -> DenseFreezingDrizzle
                WeatherCodes.SLIGHT_RAIN -> SlightRain
                WeatherCodes.MODERATE_RAIN -> ModerateRain
                WeatherCodes.HEAVY_RAIN -> HeavyRain
                WeatherCodes.LIGHT_FREEZING_RAIN -> LightFreezingDrizzle
                WeatherCodes.HEAVY_FREEZING_RAIN -> HeavyFreezingRain
                WeatherCodes.SLIGHT_SNOWFALL -> SlightSnowFall
                WeatherCodes.MODERATE_SNOWFALL -> ModerateSnowFall
                WeatherCodes.HEAVY_SNOWFALL -> HeavySnowFall
                WeatherCodes.SNOW_GRAINS -> SnowGrains
                WeatherCodes.SLIGHT_RAIN_SHOWERS -> SlightRainShowers
                WeatherCodes.MODERATE_RAIN_SHOWERS -> ModerateRainShowers
                WeatherCodes.VIOLENT_RAIN_SHOWERS -> ViolentRainShowers
                WeatherCodes.SLIGHT_SNOW_SHOWERS -> SlightSnowShowers
                WeatherCodes.HEAVY_SNOW_SHOWERS -> HeavySnowShowers
                WeatherCodes.MODERATE_THUNDERSTORM -> ModerateThunderstorm
                WeatherCodes.SLIGHT_HAIL_THUNDERSTORM -> SlightHailThunderstorm
                WeatherCodes.HEAVY_HAIL_THUNDERSTORM -> HeavyHailThunderstorm
                else -> Unknown
            }
        }
    }
}
