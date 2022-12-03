package com.example.sunshine.data.remote

import com.google.gson.annotations.SerializedName

class Forecast {
    @SerializedName("latitude")
    val latitude: Double? = null

    @SerializedName("longitude")
    val longitude: Double? = null

    @SerializedName("generationtime_ms")
    val generationtimeMs: Double? = null

    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int? = null

    @SerializedName("timezone")
    val timezone: String? = null

    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String? = null

    @SerializedName("elevation")
    val elevation: Double? = null

    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits? = null

    @SerializedName("hourly")
    val hourly: Hourly? = null
}
