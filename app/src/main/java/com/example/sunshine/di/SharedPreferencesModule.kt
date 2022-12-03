package com.example.sunshine.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

const val SHARED_PREFERENCE_DEFAULT = "DEFAULT_SHARED_PREFERENCES"

@Module
@InstallIn(SingletonComponent::class)
class SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCE_DEFAULT, MODE_PRIVATE)
    }
}
