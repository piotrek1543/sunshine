package com.example.sunshine.di

import android.content.Context
import androidx.room.Room
import com.example.sunshine.data.cache.SunshineDatabase
import com.example.sunshine.data.cache.SunshineDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): SunshineDatabase = Room
        .databaseBuilder(context, SunshineDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun cachedWeatherDataDao(db: SunshineDatabase) = db.cachedWeatherDataDao()
}
