package com.example.sunshine.data.remote.service

import com.example.sunshine.data.remote.model.Forecast
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastService {
    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
    suspend fun getForecast(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): Forecast
}
