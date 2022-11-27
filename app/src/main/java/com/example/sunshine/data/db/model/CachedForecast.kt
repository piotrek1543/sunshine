package com.example.sunshine.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sunshine.data.db.constants.ForecastConstants

/**
 * Model used solely for the caching of a Forecast
 */
@Entity(tableName = ForecastConstants.TABLE_NAME)
data class CachedForecast(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        //var cachedCity: CachedCity? = null,
        var cod: String? = null,
        var message: Double? = null,
        var cnt: Int? = null
        // var cachedList: kotlin.collections.List<CachedList>? = null
)
