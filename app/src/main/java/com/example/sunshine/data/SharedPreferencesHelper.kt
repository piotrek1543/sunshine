package com.example.sunshine.data

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 * General Preferences Helper class, used for storing preference values using the Preference API
 */
@Singleton
open class SharedPreferencesHelper @Inject constructor(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val PREF_KEY_LAST_CACHE = "last_cache"

        private const val PREF_KEY_IS_METRIC = "is_metric"
    }

    /**
     * Store and retrieve the last time data was cached
     */
    var lastCacheTime: Long
        get() = sharedPreferences.getLong(PREF_KEY_LAST_CACHE, 0)
        set(lastCache) = sharedPreferences.edit().putLong(PREF_KEY_LAST_CACHE, lastCache).apply()

    var isMetric: Boolean
        get() = sharedPreferences.getBoolean(PREF_KEY_IS_METRIC, true)
        set(metric) = sharedPreferences.edit().putBoolean(PREF_KEY_IS_METRIC, metric).apply()
}
