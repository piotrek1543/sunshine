package com.example.sunshine.data.remote.model

import com.google.gson.annotations.SerializedName

class ForecastModel(
    @SerializedName("city")
    var city: CityModel? = null,
    @SerializedName("cod")
    var cod: String? = null,
    @SerializedName("message")
    var message: Double? = null,
    @SerializedName("cnt")
    var cnt: Int? = null,
    @SerializedName("list")
    var list: List<ListModel>? = null
)
