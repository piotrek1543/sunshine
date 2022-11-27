package com.example.sunshine.data.remote.model

import com.google.gson.annotations.SerializedName

class WeatherModel(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("main")
    var main: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("icon")
    var icon: String? = null,
    var listDt: Long? = null
)
