package com.example.sunshine.data.remote.model

import com.google.gson.annotations.SerializedName

class WindModel(
    @SerializedName("speed")
    var speed: Double? = null,
    @SerializedName("deg")
    var deg: Float? = null,
    var listDt: Long? = null
)
