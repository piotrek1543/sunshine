package com.example.sunshine.di

import com.example.sunshine.data.db.SunshineDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideCachedCityDao(db: SunshineDatabase) = db.cachedCityDao()

    @Provides
    @Singleton
    fun provideCachedCloudsDao(db: SunshineDatabase) = db.cachedCloudsDao()

    @Provides
    @Singleton
    fun provideCachedCoordDao(db: SunshineDatabase) = db.cachedCoordDao()

    @Provides
    @Singleton
    fun provideCachedForecastDao(db: SunshineDatabase) = db.cachedForecastDao()

    @Provides
    @Singleton
    fun provideCachedListDao(db: SunshineDatabase) = db.cachedListDao()

    @Provides
    @Singleton
    fun provideCachedMainDao(db: SunshineDatabase) = db.cachedMainDao()

    @Provides
    @Singleton
    fun provideCachedPodDao(db: SunshineDatabase) = db.cachedPodDao()

    @Provides
    @Singleton
    fun provideCachedRainDao(db: SunshineDatabase) = db.cachedRainDao()

    @Provides
    @Singleton
    fun provideCachedSnowDao(db: SunshineDatabase) = db.cachedSnowDao()

    @Provides
    @Singleton
    fun provideCachedWeatherDao(db: SunshineDatabase) = db.cachedWeatherDao()

    @Provides
    @Singleton
    fun provideCachedWindDao(db: SunshineDatabase) = db.cachedWindDao()
}
