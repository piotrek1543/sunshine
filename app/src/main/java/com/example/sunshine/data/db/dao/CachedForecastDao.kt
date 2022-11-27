package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.ForecastConstants
import com.example.sunshine.data.db.model.CachedForecast

@Dao
abstract class CachedForecastDao {

    @Query(ForecastConstants.QUERY_FORECAST)
    abstract fun getForecast(): CachedForecast?

    @Query(ForecastConstants.DELETE_ALL_FORECASTS)
    abstract fun clearForecast()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertForecast(cachedForecast: CachedForecast)

}