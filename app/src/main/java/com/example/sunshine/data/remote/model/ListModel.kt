package com.example.sunshine.data.remote.model

import com.google.gson.annotations.SerializedName

class ListModel(
    @SerializedName("dt")
    var dt: Long? = null,
    @SerializedName("main")
    var mainModel: MainModel? = null,
    @SerializedName("weather")
    var weatherModel: List<WeatherModel>? = null,
    @SerializedName("clouds")
    var cloudsModel: CloudsModel? = null,
    @SerializedName("wind")
    var windModel: WindModel? = null,
    @SerializedName("rainModel")
    var rainModel: RainModel? = null,
    @SerializedName("snowModel")
    var snowModel: SnowModel? = null,
    @SerializedName("sys")
    var podModel: PodModel? = null,
    @SerializedName("dt_txt")
    var dtTxt: String? = null,
    var listDt: Long? = null
)
