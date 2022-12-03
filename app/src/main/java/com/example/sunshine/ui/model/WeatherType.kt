package com.example.sunshine.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.sunshine.R

sealed class WeatherType(
    @StringRes val descriptionRes: Int,
    @DrawableRes val iconRes: Int
) {
    object ClearSky : WeatherType(
        descriptionRes = R.string.weather_type_clear_sky_,
        iconRes = R.drawable.ic_sunny
    )

    object MainlyClear : WeatherType(
        descriptionRes = R.string.weather_type_mainly_clear,
        iconRes = R.drawable.ic_cloudy
    )

    object PartlyCloudy : WeatherType(
        descriptionRes = R.string.weather_type_partly_cloudy,
        iconRes = R.drawable.ic_cloudy
    )

    object Overcast : WeatherType(
        descriptionRes = R.string.weather_type_overcast,
        iconRes = R.drawable.ic_cloudy
    )

    object Foggy : WeatherType(
        descriptionRes = R.string.weather_type_foggy,
        iconRes = R.drawable.ic_very_cloudy
    )

    object DepositingRimeFog : WeatherType(
        descriptionRes = R.string.weather_type_depositing_rime_fog,
        iconRes = R.drawable.ic_very_cloudy
    )

    object LightDrizzle : WeatherType(
        descriptionRes = R.string.weather_type_light_drizzle,
        iconRes = R.drawable.ic_rainshower
    )

    object ModerateDrizzle : WeatherType(
        descriptionRes = R.string.weather_type_moderate_drizzle,
        iconRes = R.drawable.ic_rainshower
    )

    object DenseDrizzle : WeatherType(
        descriptionRes = R.string.weather_type_dense_drizzle,
        iconRes = R.drawable.ic_rainshower
    )

    object LightFreezingDrizzle : WeatherType(
        descriptionRes = R.string.weather_type_slight_freezing_drizzle,
        iconRes = R.drawable.ic_snowyrainy
    )

    object DenseFreezingDrizzle : WeatherType(
        descriptionRes = R.string.weather_type_dense_freezing_drizzle,
        iconRes = R.drawable.ic_snowyrainy
    )

    object SlightRain : WeatherType(
        descriptionRes = R.string.weather_type_slight_rain,
        iconRes = R.drawable.ic_rainy
    )

    object ModerateRain : WeatherType(
        descriptionRes = R.string.weather_type_rainy,
        iconRes = R.drawable.ic_rainy
    )

    object HeavyRain : WeatherType(
        descriptionRes = R.string.weather_type_heavy_rain,
        iconRes = R.drawable.ic_rainy
    )

    object HeavyFreezingRain : WeatherType(
        descriptionRes = R.string.weather_type_heavy_freezing_rain,
        iconRes = R.drawable.ic_snowyrainy
    )

    object SlightSnowFall : WeatherType(
        descriptionRes = R.string.weather_type_slight_snow_fall,
        iconRes = R.drawable.ic_snowy
    )

    object ModerateSnowFall : WeatherType(
        descriptionRes = R.string.weather_type_moderate_snow_fall,
        iconRes = R.drawable.ic_heavysnow
    )

    object HeavySnowFall : WeatherType(
        descriptionRes = R.string.weather_type_heavy_snow_fall,
        iconRes = R.drawable.ic_heavysnow
    )

    object SnowGrains : WeatherType(
        descriptionRes = R.string.weather_type_snow_grains,
        iconRes = R.drawable.ic_heavysnow
    )

    object SlightRainShowers : WeatherType(
        descriptionRes = R.string.weather_type_slight_rain_showers,
        iconRes = R.drawable.ic_rainshower
    )

    object ModerateRainShowers : WeatherType(
        descriptionRes = R.string.weather_type_moderate_rain_showers,
        iconRes = R.drawable.ic_rainshower
    )

    object ViolentRainShowers : WeatherType(
        descriptionRes = R.string.weather_type_heavy_snow_showers,
        iconRes = R.drawable.ic_rainshower
    )

    object SlightSnowShowers : WeatherType(
        descriptionRes = R.string.weather_type_light_snow_showers,
        iconRes = R.drawable.ic_snowy
    )

    object HeavySnowShowers : WeatherType(
        descriptionRes = R.string.weather_type_heavy_snow_showers,
        iconRes = R.drawable.ic_snowy
    )

    object ModerateThunderstorm : WeatherType(
        descriptionRes = R.string.weather_type_moderate_thunderstorm,
        iconRes = R.drawable.ic_thunder
    )

    object SlightHailThunderstorm : WeatherType(
        descriptionRes = R.string.weather_type_thunderstorm_with_slight_hail,
        iconRes = R.drawable.ic_rainythunder
    )

    object HeavyHailThunderstorm : WeatherType(
        descriptionRes = R.string.weather_type_thunderstorm_with_heavy_hail,
        iconRes = R.drawable.ic_rainythunder
    )

    object Unknown : WeatherType(
        descriptionRes = R.string.weather_type_unknown,
        iconRes = R.drawable.ic_rainythunder
    )

    companion object {
        @Suppress("MagicNumber", "ComplexMethod")
        fun of(code: Int?): WeatherType {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> Unknown
            }
        }
    }
}
