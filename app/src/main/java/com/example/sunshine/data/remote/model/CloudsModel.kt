package com.example.sunshine.data.remote.model

import com.google.gson.annotations.SerializedName


class CloudsModel(
    @SerializedName("all")
    var all: Int? = null,
    var listDt: Long? = null
)
