package com.example.sunshine.data.remote

import com.google.gson.annotations.SerializedName

class HourlyUnits {
    @SerializedName("time")
    val time: String? = null

    @SerializedName("temperature_2m")
    val temperature2m: String? = null

    @SerializedName("weathercode")
    val weathercode: String? = null

    @SerializedName("relativehumidity_2m")
    val relativehumidity2m: String? = null

    @SerializedName("windspeed_10m")
    val windspeed10m: String? = null

    @SerializedName("pressure_msl")
    val pressureMsl: String? = null
}
