package com.example.sunshine.di

import com.example.sunshine.data.cache.SunshineDatabase
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
    fun cachedWeatherDataDao(db: SunshineDatabase) = db.cachedWeatherDataDao()
}
