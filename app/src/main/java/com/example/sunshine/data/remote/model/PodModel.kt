package com.example.sunshine.data.remote.model

import com.google.gson.annotations.SerializedName

class PodModel(
    @SerializedName("pod")
    var pod: String? = null,
    var listDt: Long? = null
)
