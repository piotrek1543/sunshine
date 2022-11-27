package com.example.sunshine.data.remote.model

import com.google.gson.annotations.SerializedName

class MainModel(
    @SerializedName("temp")
    var temp: Double? = null,
    @SerializedName("temp_min")
    var tempMin: Double? = null,
    @SerializedName("temp_max")
    var tempMax: Double? = null,
    @SerializedName("pressure")
    var pressure: String? = null,
    @SerializedName("sea_level")
    var seaLevel: String? = null,
    @SerializedName("grnd_level")
    var grndLevel: String? = null,
    @SerializedName("humidity")
    var humidity: Int? = null,
    @SerializedName("temp_kf")
    var tempKf: String? = null,
    var listDt: Long? = null
)
