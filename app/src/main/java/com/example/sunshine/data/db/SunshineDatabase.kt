package com.example.sunshine.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sunshine.data.db.dao.CachedCityDao
import com.example.sunshine.data.db.dao.CachedCloudsDao
import com.example.sunshine.data.db.dao.CachedCoordDao
import com.example.sunshine.data.db.dao.CachedForecastDao
import com.example.sunshine.data.db.dao.CachedListDao
import com.example.sunshine.data.db.dao.CachedMainDao
import com.example.sunshine.data.db.dao.CachedPodDao
import com.example.sunshine.data.db.dao.CachedRainDao
import com.example.sunshine.data.db.dao.CachedSnowDao
import com.example.sunshine.data.db.dao.CachedWeatherDao
import com.example.sunshine.data.db.dao.CachedWindDao
import com.example.sunshine.data.db.model.CachedCity
import com.example.sunshine.data.db.model.CachedClouds
import com.example.sunshine.data.db.model.CachedCoord
import com.example.sunshine.data.db.model.CachedForecast
import com.example.sunshine.data.db.model.CachedList
import com.example.sunshine.data.db.model.CachedMain
import com.example.sunshine.data.db.model.CachedPod
import com.example.sunshine.data.db.model.CachedRain
import com.example.sunshine.data.db.model.CachedSnow
import com.example.sunshine.data.db.model.CachedWeather
import com.example.sunshine.data.db.model.CachedWind

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
