package com.example.sunshine.data.remote.model

import com.google.gson.annotations.SerializedName

class Hourly {
    @SerializedName("time")
    val time: List<String>? = null

    @SerializedName("temperature_2m")
    val temperature2m: List<Double>? = null

    @SerializedName("weathercode")
    val weathercode: List<Int>? = null

    @SerializedName("relativehumidity_2m")
    val relativehumidity2m: List<Int>? = null

    @SerializedName("windspeed_10m")
    val windspeed10m: List<Double>? = null

    @SerializedName("pressure_msl")
    val pressureMsl: List<Double>? = null
}
