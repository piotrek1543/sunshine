package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.WeatherConstants
import com.example.sunshine.data.db.model.CachedWeather

@Dao
interface CachedWeatherDao {

    @Query(WeatherConstants.QUERY_WEATHER)
    suspend fun getWeather(): List<CachedWeather>?

    @Query(WeatherConstants.DELETE_ALL_WEATHERS)
    suspend fun clearWeather()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(cachedWeather: List<CachedWeather>?)
}
