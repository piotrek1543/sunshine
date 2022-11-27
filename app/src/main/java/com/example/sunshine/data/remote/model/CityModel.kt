package com.example.sunshine.data.remote.model

import com.google.gson.annotations.SerializedName

class CityModel(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("coord")
    var coord: CoordModel? = null,
    @SerializedName("country")
    var country: String? = null,
    @SerializedName("population")
    var population: Int? = null
)
