package com.example.sunshine.data.remote


import com.example.sunshine.data.remote.model.ForecastModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastService {

    @GET("forecast/")
    suspend fun get(@Query("q") q: String,
                     @Query("mode") mode: String,
                     @Query("units") units: String,
                     @Query("type") type: String,
                     @Query("lang") lang: String,
                     @Query("appid") appId: String): ForecastModel
}