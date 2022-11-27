package com.example.sunshine.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sunshine.data.db.dao.*
import com.example.sunshine.data.db.model.*

@Database(
    entities = [
        CachedCity::class,
        CachedClouds::class,
        CachedCoord::class,
        CachedForecast::class,
        CachedList::class,
        CachedMain::class,
        CachedPod::class,
        CachedRain::class,
        CachedSnow::class,
        CachedWeather::class,
        CachedWind::class
    ],
    exportSchema = false,
    version = 1
)
abstract class SunshineDatabase : RoomDatabase() {

    abstract fun cachedCityDao(): CachedCityDao

    abstract fun cachedCloudsDao(): CachedCloudsDao

    abstract fun cachedCoordDao(): CachedCoordDao

    abstract fun cachedForecastDao(): CachedForecastDao

    abstract fun cachedListDao(): CachedListDao

    abstract fun cachedMainDao(): CachedMainDao

    abstract fun cachedPodDao(): CachedPodDao

    abstract fun cachedRainDao(): CachedRainDao

    abstract fun cachedSnowDao(): CachedSnowDao

    abstract fun cachedWeatherDao(): CachedWeatherDao

    abstract fun cachedWindDao(): CachedWindDao

}