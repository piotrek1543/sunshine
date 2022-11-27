package com.example.sunshine.data.remote.model

import com.google.gson.annotations.SerializedName

class SnowModel(
    @SerializedName("3h")
    var in3h: Double? = null,
    var listDt: Long? = null
)
