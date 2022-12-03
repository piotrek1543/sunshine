package com.example.sunshine.di

import com.example.sunshine.data.repository.ForecastRepositoryImpl
import com.example.sunshine.domain.repository.ForecastRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindWeatherRepository(
        weatherRepositoryImpl: ForecastRepositoryImpl
    ): ForecastRepository
}
