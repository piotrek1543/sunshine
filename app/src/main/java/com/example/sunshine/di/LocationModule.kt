package com.example.sunshine.di

import com.example.sunshine.data.location.DefaultLocationTracker
import com.example.sunshine.domain.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
interface LocationModule {

    @Binds
    @Singleton
    fun bindLocationTracker(defaultLocationTracker: DefaultLocationTracker): LocationTracker
}
