package com.example.sunshine.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.cache.model.CachedWeatherData

@Dao
interface CachedWeatherDataDao {

    @Query("SELECT * FROM weather_data")
    suspend fun getAll(): List<CachedWeatherData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weatherData: CachedWeatherData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(weatherData: List<CachedWeatherData>)
}
