package com.example.sunshine.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sunshine.data.db.constants.RainConstants
import com.example.sunshine.data.db.model.CachedRain

@Dao
abstract class CachedRainDao {

    @Query(RainConstants.QUERY_RAIN)
    abstract fun getRain(): List<CachedRain>?

    @Query(RainConstants.DELETE_ALL_RAINS)
    abstract fun clearRain()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertRain(cachedRain: List<CachedRain>?)

}