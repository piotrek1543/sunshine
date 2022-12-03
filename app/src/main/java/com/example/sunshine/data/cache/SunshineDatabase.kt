package com.example.sunshine.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sunshine.data.cache.dao.CachedWeatherDataDao
import com.example.sunshine.data.cache.model.CachedWeatherData

@Database(
    entities = [
        CachedWeatherData::class,
    ],
    exportSchema = false,
    version = 1
)
@TypeConverters(Converters::class)
abstract class SunshineDatabase : RoomDatabase() {

    abstract fun cachedWeatherDataDao(): CachedWeatherDataDao
}
