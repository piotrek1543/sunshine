package com.example.sunshine.data.remote.model

import com.google.gson.annotations.SerializedName


class CoordModel(
    @SerializedName("lon")
    var lon: Double? = null,
    @SerializedName("lat")
    var lat: Double? = null,
    var cityId: Int? = null
)
